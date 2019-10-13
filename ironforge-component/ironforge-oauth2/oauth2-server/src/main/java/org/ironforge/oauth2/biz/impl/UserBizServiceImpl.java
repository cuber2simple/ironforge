package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.ironforge.biz.BeanCopyBizService;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.constants.IronforgeConstant;
import org.ironforge.oauth2.biz.RoleBizService;
import org.ironforge.oauth2.biz.UserBizService;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Slf4j
public class UserBizServiceImpl extends BeanCopyBizService<UserService, TUser, Integer, User> implements UserBizService {

    public UserBizServiceImpl() {
        super(TUser.class, User.class);
    }

    @Autowired
    private RoleBizService roleBizService;

    @Override
    public User findByUserId(String userId) {
        return entityTransferBO(service.findByUserId(userId));
    }

    @Override
    public PageResp<User> pageQuery(PageReq<UserQuery> pageReq) {
        //暂不实现
        return null;
    }

    @Override
    public FrontUser fetch(String userId) {
        FrontUser frontUser = null;
        User user = findByUserId(userId);
        if (Objects.nonNull(user)) {
            frontUser = new FrontUser();
            frontUser.setUser(user);
            List<Role> roles = roleBizService.findByUserId(user.getUserId());
            frontUser.setOwnRoles(roles);
            if (CollectionUtils.isNotEmpty(roles)) {
                Optional<Role> superUser = roles.stream()
                        .filter(role -> IronforgeConstant.TRUE_STRING.equals(role.getSuperManager())).findFirst();
                frontUser.setSuperUser(superUser.isPresent());
                
            }
        }
        return frontUser;
    }

    @Override
    public Boolean resetRole(String userId, List<String> roles) {
        return null;
    }

    @Override
    public List<Role> roles(String userId) {
        return roleBizService.findByUserId(userId);
    }
}
