package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.biz.UserBizService;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.service.UserService;
import org.ironforge.transfer.BeanCopyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserBizServiceImpl extends BeanCopyTransfer<TUser, User> implements UserBizService {
    @Autowired
    private UserService userService;

    public UserBizServiceImpl() {
        super(TUser.class, User.class);
    }


    @Override
    public User findByUserId(String userId) {
        return entityTransferBO(userService.findByUserId(userId));
    }

    @Override
    public PageResp<User> pageQuery(PageReq<UserQuery> pageReq) {
        return null;
    }

    @Override
    public FrontUser fetch(String userId) {
        FrontUser frontUser = null;
        User user = findByUserId(userId);
        if(Objects.nonNull(user)){
            frontUser = new FrontUser();
            frontUser.setUser(user);
        }
        return frontUser;
    }

    @Override
    public Boolean resetRole(String userId, List<String> roles) {
        return null;
    }

    @Override
    public List<Role> roles(String userId) {
        return null;
    }
}
