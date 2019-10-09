package org.ironforge.oauth2.client.user;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.client.fallback.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "oauth2", path = "/user", fallbackFactory = UserFallbackFactory.class)
public interface UserFeignClient {
    @PostMapping("/add")
    /**
     * 新增一个用户
     * @param user
     * @return
     */
    IronforgeResp<User> add(@RequestBody User user);

    @GetMapping("/{userId}")
    /**
     * 查找用户根据用户ID
     * @return
     */
    IronforgeResp<User> findByUserId(@PathVariable("userId") String userId);

    /**
     * 分页查询
     *
     * @param pageReq
     * @return
     */
    @PostMapping("/page")
    PageResp<User> pageQuery(PageReq<UserQuery> pageReq);

    /**
     * 根据登录的token 返回当前用户的权限及菜单
     *
     * @return
     */
    @GetMapping("/front/fetch")
    IronforgeResp<FrontUser> fetch();


    /**
     * 设置用户权限
     *
     * @param userId
     * @param roles
     * @return
     */
    @PostMapping("/{userId}/role/set")
    IronforgeResp<Boolean> resetRole(@PathVariable("userId") String userId, @RequestBody List<String> roles);

    /**
     * 查找该用户下所有的权限
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}/role")
    IronforgeResp<List<Role>> roles(@PathVariable("userId") String userId);
}
