package org.ironforge.oauth2.rest;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.client.user.UserFeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserRest implements UserFeignClient {
    @Override
    public IronforgeResp<User> add(User user) {
        return null;
    }

    @Override
    public IronforgeResp<User> findByUserId(String userId) {
        return null;
    }

    @Override
    public PageResp<User> pageQuery(PageReq<UserQuery> pageReq) {
        return null;
    }

    @Override
    public IronforgeResp<FrontUser> fetch() {
        return null;
    }

    @Override
    public IronforgeResp<Boolean> resetRole(String userId, List<String> roles) {
        return null;
    }

    @Override
    public IronforgeResp<List<Role>> roles(String userId) {
        return null;
    }
}
