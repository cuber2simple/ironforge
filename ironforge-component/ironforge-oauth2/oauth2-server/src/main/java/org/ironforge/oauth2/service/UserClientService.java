package org.ironforge.oauth2.service;

import org.apache.commons.lang3.StringUtils;
import org.ironforge.oauth2.persist.entity.TUserClient;
import org.ironforge.oauth2.persist.repo.UserClientRepository;
import org.ironforge.oauth2.utils.ClientUtils;
import org.ironforge.service.IronforgeService;
import org.ironforge.utils.RsaUtils;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class UserClientService extends IronforgeService<UserClientRepository, TUserClient, Integer> {
    public TUserClient findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    public TUserClient findByAppId(String appId) {
        return repository.findByAppId(appId);
    }

    public static final String PUBLIC_KEY_RSA = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCLNbmKl9/gLn7Bef/xtUkshC1WyrLZLRpXCcFYR1gQi0isWsZBTicC4efBOkkNG3r+1ue0gvtuU/tjREFGf4Y7HaKHGb5tNCOlMNeNjM5YLRwLFqrUSsQyD4rj4eua1ltearr24R0HilnTvnQm6Z/UY0s21vdOUFQBPY0GNAa+0wIDAQAB";

    public static final String PRIVATE_KEY_RSA = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIs1uYqX3+AufsF5//G1SSyELVbKstktGlcJwVhHWBCLSKxaxkFOJwLh58E6SQ0bev7W57SC+25T+2NEQUZ/hjsdoocZvm00I6Uw142MzlgtHAsWqtRKxDIPiuPh65rWW15quvbhHQeKWdO+dCbpn9RjSzbW905QVAE9jQY0Br7TAgMBAAECgYBcYhbzpr5no/Nyqmf0G/6nkEAWbQYrogbs5AhvcUk8EXL1DnirNhYlj42hafC4xhflrvCtlo8NNKaLxewbwN1uuzG8A2jd+ROEXlx5HDh2ZluhtHzL/SmNcJXo684xAl2pCNVBjDcW48PcIBijke/sTVHTDsDCukLKDPUOM/mKIQJBAL96k4+jBscazsJiuZ6C3RFDVtRRDpf1dMgLgxcx63bAXkA2Arau0J49IAYmSVJoDXqDoJKWdXJVh9vHSkhN/48CQQC6Hk1/G0Y0nOylf6NOp0oMgc0A+etnwxHKqwtctPKjEYcJx2fzALzTtCoySLYXX7gLnPIQXpQBTUysG5skBKp9AkEAiSQm6fqu0Q4fRlRlc+VwpnufhgPkOuw/z0OHiaZkajJPjxfgC63bl2paNG1ZmJ8UAEqkSDlhNxmRa9UqG+1ZewJASaQxz6gwCCNLM1SkfjuM/hPh1JAOh9jUUleJQF5MXx9RSho/VBQnorB3vbutaOQzw0yPLtDtSPKX8sVdhkveVQJAIDsJP5X8Tey6zXTUISor7PF0TSiKdE4k0IwKoy9y8HmQ+AU8+xyr/iOt5lvaGxKlBK8N/7yCw5H4qHnJaHT+Bg==";

    public static final int DEFAULT_ACCESS_SECONDS = 7200;

    public static final int DEFAULT_REFRESH_SECONDS = 24 * 3600;

    @Override
    public TUserClient save(TUserClient entity) {
        if (Objects.nonNull(entity)) {
            String rsaPublicKey = entity.getRsaPublicKey();
            if (StringUtils.isEmpty(rsaPublicKey)) {
                entity.setRsaPrivateKey(PRIVATE_KEY_RSA);
                entity.setRsaPublicKey(PUBLIC_KEY_RSA);
            }
            String userId = entity.getUserId();
            String merchantId = StringUtils.substring(userId, 0, 11);
            String appId = ClientUtils.getClientId(merchantId);
            entity.setAppId(appId);
            entity.setAppSecret(ClientUtils.getClientSecret(appId));
            if (Objects.isNull(entity.getAccessTokenValidity())) {
                entity.setAccessTokenValidity(DEFAULT_ACCESS_SECONDS);
            }
            if (Objects.isNull(entity.getRefreshTokenValidity())) {
                entity.setRefreshTokenValidity(DEFAULT_REFRESH_SECONDS);
            }
        }
        return super.save(entity);
    }
}
