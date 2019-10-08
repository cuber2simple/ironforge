package org.ironforge.oauth2.client.user;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.bo.complex.GatewayUser;
import org.ironforge.oauth2.bo.complex.ResetRole;
import org.ironforge.oauth2.client.fallback.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "oauth2", path = "/user", fallbackFactory = UserFallbackFactory.class)
public interface UserFeignClient {

    /**
     * 根据TOKEN查找用户
     *
     * @param token
     * @return
     */
    @GetMapping("/gateway/fetch")
    IronforgeResp<GatewayUser> fetch(@RequestParam("token") String token);

    /**
     * 根据登录的token 返回当前用户的权限及菜单
     *
     * @return
     */
    @GetMapping("/front/fetch")
    IronforgeResp<FrontUser> fetch();


    /**
     * 更改权限
     *
     * @param resetRole
     * @return
     */
    @PostMapping("/role/set")
    IronforgeResp<Boolean> resetRole(@RequestBody ResetRole resetRole);
}
