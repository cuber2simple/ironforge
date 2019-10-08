package org.ironforge.oauth2.biz;


import org.ironforge.bo.Token;
import org.ironforge.oauth2.persist.entity.TUser;

public interface TokenBizService {

    Token makeToken(TUser tUser);


}
