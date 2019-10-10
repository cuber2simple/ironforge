package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.biz.RoleBizService;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;
import org.ironforge.oauth2.persist.entity.TRole;
import org.ironforge.oauth2.service.RoleService;
import org.ironforge.transfer.BeanCopyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleBizServerImpl extends BeanCopyTransfer<TRole, Role> implements RoleBizService {

    @Autowired
    private RoleService roleService;

    public RoleBizServerImpl() {
        super(TRole.class, Role.class);
    }

    @Override
    public Role add(Role role) {
        TRole result = roleService.save(boTransferEntity(role));
        return entityTransferBO(result);
    }

    @Override
    public Role edit(Role role) {
        TRole result = roleService.update(boTransferEntity(role));
        return entityTransferBO(result);
    }

    @Override
    public PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq) {
        //暂不实现
        return null;
    }

    @Override
    public Role findById(Integer id) {
        return entityTransferBO(roleService.findById(id).get());
    }

    @Override
    public boolean resetRole(String roleCode, List<String> resourceCode) {
        return false;
    }

    @Override
    public List<Role> roles(String roleCode) {
        return null;
    }

    @Override
    public List<Role> findByUserId(String userId) {
        return null;
    }
}
