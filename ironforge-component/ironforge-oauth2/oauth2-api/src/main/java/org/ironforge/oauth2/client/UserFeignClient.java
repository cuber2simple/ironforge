package org.ironforge.oauth2.client;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.client.fallback.UserFallbackFactory;
import org.ironforge.valid.anno.ValidCheck;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "oauth2", path = "/user", fallbackFactory = UserFallbackFactory.class)
public interface UserFeignClient {

    @PostMapping("/login")
    @ValidCheck
    IronforgeResp<Token> login(@RequestBody Login login);
}
