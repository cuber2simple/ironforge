package org.ironforge.oauth2.service;

import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;
import org.apache.commons.lang3.StringUtils;
import org.ironforge.constants.IronforgeCode;
import org.ironforge.err.IronforgeException;
import org.ironforge.oauth2.enums.UserType;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.repo.UserRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserService extends IronforgeService<UserRepository, TUser, Integer> {

    private static final String DEFAULT_PASSWORD = "12345678";

    public TUser findByMerchantIdAndUserName(String merchantId, String userName) {
        return repository.findByMerchantIdAndUserName(merchantId, userName);
    }

    public TUser findByMerchantIdAndEmail(String merchantId, String email) {
        return repository.findByMerchantIdAndEmail(merchantId, email);
    }

    public TUser findByUserId(String userId) {
        return repository.findByUserId(userId);
    }

    @Override
    public TUser save(TUser entity) {
        //客户端ID
        Integer userIdPart = 99999999;
        if (UserType.operator.getCode().equals(entity.getUserType())) {
            userIdPart = repository.findBigUserIdUnderMerchantId(entity.getMerchantId());
            //没有查找到，设置为空啊
            if (Objects.isNull(userIdPart)) {
                userIdPart = 0;
            }
            userIdPart = userIdPart + 1;
        }
        String userId = entity.getMerchantId() + String.format("%08d", userIdPart);
        entity.setUserId(userId);
        hmacPassword(entity);
        return super.save(entity);
    }

    private void hmacPassword(TUser entity) {
        if (Objects.nonNull(entity)) {
            String hmacPassword = getHmacPassword(entity);
            entity.setPassword(hmacPassword);
        }
    }

    private String getHmacPassword(TUser tUser) {
        String originPassword = tUser.getPassword();
        if (StringUtils.isNotEmpty(originPassword)) {
            originPassword = DEFAULT_PASSWORD;
        }
        String userName = tUser.getUserName();
        userName = StringUtils.defaultString(userName, StringUtils.EMPTY);
        String hmacPassword = new HmacUtils(HmacAlgorithms.HMAC_SHA_512, userName).hmacHex(originPassword);
        return hmacPassword;
    }

    public TUser updatePassword(String userId, String originPassword, String newPassword) {
        if (StringUtils.isEmpty(originPassword)) {
            throw new IronforgeException(IronforgeCode.INVALID_ARGUMENT.getCode(), "旧密码不能为空");
        }
        if (StringUtils.equals(originPassword, newPassword)) {
            throw new IronforgeException(IronforgeCode.INVALID_ARGUMENT.getCode(), "新旧密码不能相同");
        }
        TUser dbUser = this.findByUserId(userId);
        String oldPassword = dbUser.getPassword();
        dbUser.setPassword(originPassword);
        String hmacPassword = getHmacPassword(dbUser);
        if (!oldPassword.equals(hmacPassword)) {
            throw new IronforgeException(IronforgeCode.INVALID_ARGUMENT.getCode(), "密码不对");
        }
        dbUser.setPassword(newPassword);
        hmacPassword(dbUser);
        return super.update(dbUser);
    }

    @Override
    public TUser update(TUser entity) {
        TUser dbUser = this.findByUserId(entity.getUserId());
        //更改用户密码不能更改
        entity.setPassword(dbUser.getPassword());
        //用户名不能更改
        entity.setUserName(dbUser.getUserName());
        //用户不能更改
        entity.setUserId(dbUser.getUserId());
        return super.update(entity);
    }
}
