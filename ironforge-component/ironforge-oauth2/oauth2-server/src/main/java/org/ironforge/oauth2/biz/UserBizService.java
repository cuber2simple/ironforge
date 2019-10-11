package org.ironforge.oauth2.biz;

import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;

import java.util.List;

public interface UserBizService {

    User findByUserId(String userId);

    PageResp<User> pageQuery(PageReq<UserQuery> pageReq);

    FrontUser fetch(String userId);

    Boolean resetRole(String userId, List<String> roles);

    List<Role> roles(String userId);
}
