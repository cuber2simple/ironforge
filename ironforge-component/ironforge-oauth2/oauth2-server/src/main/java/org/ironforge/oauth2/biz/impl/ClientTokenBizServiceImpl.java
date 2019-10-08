package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.biz.ClientTokenBizService;
import org.ironforge.oauth2.persist.entity.TClientToken;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.entity.TUserClient;
import org.ironforge.oauth2.service.ClientTokenHisService;
import org.ironforge.oauth2.service.ClientTokenService;
import org.ironforge.oauth2.utils.JWTUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.Objects;

@Service
@Slf4j
public class ClientTokenBizServiceImpl implements ClientTokenBizService {

    @Autowired
    private TransactionTemplate transactionTemplate;

    @Autowired
    private ClientTokenService clientTokenService;

    @Autowired
    private ClientTokenHisService clientTokenHisService;

    @Override
    public Token genToken(TUser tUser, TUserClient tUserClient) {
        TClientToken tClientToken = clientTokenService.findByAppId(tUserClient.getAppId());
        TClientToken newClientToken = JWTUtils.genToken(tUser, tUserClient);
        transactionTemplate.execute(transactionStatus -> {
            if (Objects.nonNull(tClientToken)) {
                clientTokenService.deleteById(tClientToken.getId());
                clientTokenHisService.insertClientToken(tClientToken);
            }
            clientTokenService.save(newClientToken);
            return null;
        });
        return JWTUtils.genByTokenClient(newClientToken);
    }
}
