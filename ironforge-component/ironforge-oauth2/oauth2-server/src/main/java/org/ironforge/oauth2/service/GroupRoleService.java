package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TGroupRole;
import org.ironforge.oauth2.persist.repo.GroupRoleRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class GroupRoleService extends IronforgeService<GroupRoleRepository, TGroupRole, Integer> {
}
