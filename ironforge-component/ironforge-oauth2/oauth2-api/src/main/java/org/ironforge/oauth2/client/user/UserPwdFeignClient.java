package org.ironforge.oauth2.client.user;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.oauth2.bo.ChangePwd;
import org.ironforge.oauth2.client.fallback.UserPwdFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "oauth2", path = "/user/pwd", fallbackFactory = UserPwdFallbackFactory.class)
public interface UserPwdFeignClient {
    @PostMapping("/change")
    /**
     * 更改密码
     * @param changePwd
     * @return
     */
    IronforgeResp<Boolean> change(@RequestBody ChangePwd changePwd);

    @PutMapping("/reset/{userId}")
    /**
     * 重置密码
     * @param userId
     * @return
     */
    IronforgeResp<Boolean> resetPwd(@PathVariable("userId") String userId);
}
