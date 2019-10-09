package org.ironforge.oauth2.client;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.bo.ClientLogin;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.bo.complex.GatewayUser;
import org.ironforge.oauth2.client.fallback.TokenFallbackFactory;
import org.ironforge.valid.anno.ValidCheck;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "oauth2", path = "/token", fallbackFactory = TokenFallbackFactory.class)
public interface TokenFeignClient {
    /**
     * 用户登录
     *
     * @param login
     * @return
     */
    @PostMapping("/login")
    @ValidCheck
    IronforgeResp<Token> login(@RequestBody Login login);

    /**
     * 根据TOKEN查找用户
     *
     * @param token
     * @return
     */
    @GetMapping("/gateway/fetch")
    IronforgeResp<GatewayUser> fetch(@RequestParam("token") String token);

    /**
     * 客户端登陆
     *
     * @param clientLogin
     * @return
     */
    @PostMapping("/app")
    IronforgeResp<Token> app(@RequestBody ClientLogin clientLogin);

}
