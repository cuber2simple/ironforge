package org.ironforge.oauth2.biz;

import org.ironforge.biz.IronforgeBizService;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;
import org.ironforge.oauth2.persist.entity.TRole;

import java.util.List;

public interface RoleBizService extends IronforgeBizService<Role, TRole, Integer> {

    PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq);

    boolean resetRole(String roleCode, List<String> resourceCodes);

    /**
     * 根据roleCode得到resource
     *
     * @param roleCode
     * @return
     */
    List<Resource> resources(String roleCode);

    List<Role> findByUserId(String userId);

    /**
     * 查询url 关联的role
     *
     * @param url
     * @return
     */
    List<Role> findByUrl(String url);
}
