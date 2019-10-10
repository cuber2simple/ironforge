package org.ironforge.oauth2.biz;

import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;

import java.util.List;

public interface RoleBizService {

    Role add(Role role);

    Role edit(Role role);

    PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq);

    Role findById(Integer id);

    boolean resetRole(String roleCode, List<String> resourceCode);

    List<Role> roles(String roleCode);

    List<Role> findByUserId(String userId);
}
