package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TUserRole;
import org.ironforge.oauth2.persist.repo.UserRoleRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService extends IronforgeService<UserRoleRepository, TUserRole, Integer> {
}
