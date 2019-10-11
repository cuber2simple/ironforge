package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.checkerframework.checker.units.qual.A;
import org.ironforge.biz.BeanCopyBizService;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.biz.ResourceBizService;
import org.ironforge.oauth2.biz.RoleBizService;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;
import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.entity.TResourceRole;
import org.ironforge.oauth2.persist.entity.TRole;
import org.ironforge.oauth2.service.ResourceRoleService;
import org.ironforge.oauth2.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class RoleBizServerImpl extends BeanCopyBizService<RoleService, TRole, Integer, Role> implements RoleBizService {

    @Autowired
    private ResourceRoleService resourceRoleService;

    @Autowired
    private ResourceBizService resourceBizService;

    public RoleBizServerImpl() {
        super(TRole.class, Role.class);
    }


    @Override
    public PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq) {
        //暂不实现
        return null;
    }

    @Override
    @Transactional
    public boolean resetRole(String roleCode, List<String> resourceCodes) {
        resourceRoleService.deleteByRoleCode(roleCode);
        if (CollectionUtils.isNotEmpty(resourceCodes)) {
            List<TResourceRole> resourceRoles =
                    resourceCodes.stream().map(resourceCode -> instance(roleCode, resourceCode)).collect(Collectors.toList());
            resourceRoleService.saveAll(resourceRoles);
        }
        return true;
    }

    private TResourceRole instance(String roleCode, String resourceCode) {
        return new TResourceRole(resourceCode, roleCode);
    }

    @Override
    public List<Resource> resources(String roleCode) {
        List<TResource> resources = service.resources(roleCode);
        return resourceBizService.batchTransferBO(resources);
    }


    @Override
    public List<Role> findByUserId(String userId) {
        return batchTransferBO(service.findByUserId(userId));
    }

    @Override
    public List<Role> findByUrl(String url) {
        return batchTransferBO(service.findByUrl(url));
    }
}
