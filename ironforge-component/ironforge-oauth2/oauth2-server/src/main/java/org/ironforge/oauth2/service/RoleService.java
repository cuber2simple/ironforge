package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TRole;
import org.ironforge.oauth2.persist.repo.RoleRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends IronforgeService<RoleRepository, TRole, Integer> {
}
