package org.ironforge.oauth2.rest;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.client.UserFeignClient;
import org.ironforge.valid.anno.ValidCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRest implements UserFeignClient {

    @Override
    @ValidCheck
    public IronforgeResp<Token> login(Login login) {
        return null;
    }
}
