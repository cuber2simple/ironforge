package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TRole;
import org.ironforge.oauth2.persist.repo.RoleRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService extends IronforgeService<RoleRepository, TRole, Integer> {
    public TRole findByRoleCode(String roleCode) {
        return repository.findByRoleCode(roleCode);
    }

    public List<TRole> findByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
