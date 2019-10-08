package org.ironforge.oauth2.client.user;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.client.fallback.UserCurdFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "oauth2", path = "/user", fallbackFactory = UserCurdFallbackFactory.class)
public interface UserCurdFeignClient {
    @PostMapping("/add")
    /**
     * 新增一个用户
     * @param user
     * @return
     */
    IronforgeResp<User> insertUser(@RequestBody User user);

    @GetMapping("/{userId}")
    /**
     * 查找用户根据用户ID
     * @return
     */
    IronforgeResp<User> findByUserId(@PathVariable("userId") String userId);
}
