package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TResourceRole;
import org.ironforge.oauth2.persist.repo.ResourceRoleRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class ResourceRoleService extends IronforgeService<ResourceRoleRepository, TResourceRole, Integer> {
}
