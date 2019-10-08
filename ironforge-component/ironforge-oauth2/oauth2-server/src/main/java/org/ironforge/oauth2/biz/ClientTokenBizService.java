package org.ironforge.oauth2.biz;


import org.ironforge.bo.Token;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.entity.TUserClient;

public interface ClientTokenBizService {
    Token genToken(TUser tUser, TUserClient tUserClient);
}
