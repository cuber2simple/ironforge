package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.biz.ClientTokenBizService;
import org.ironforge.oauth2.biz.TokenBizService;
import org.ironforge.oauth2.enums.UserType;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.entity.TUserClient;
import org.ironforge.oauth2.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TokenBizServiceImpl implements TokenBizService {

    @Autowired
    private ClientTokenBizService clientTokenBizService;

    @Autowired
    private UserClientService userClientService;


    @Override
    public Token makeToken(TUser tUser) {
        TUserClient tUserClient = null;
        if (UserType.client.getCode().equals(tUser.getUserType())) {
            tUserClient = userClientService.findByUserId(tUser.getUserId());
        } else {
            tUserClient = fakeOne(tUser);
        }
        return clientTokenBizService.genToken(tUser, tUserClient);
    }

    private TUserClient fakeOne(TUser tUser) {
        TUserClient tUserClient = new TUserClient();
        tUserClient.setAppId(tUser.getUserId());
        tUserClient.setAccessTokenValidity(UserClientService.DEFAULT_REFRESH_SECONDS);
        tUserClient.setRefreshTokenValidity(UserClientService.DEFAULT_REFRESH_SECONDS);
        tUserClient.setUserId(tUser.getUserId());
        return tUserClient;
    }
}
