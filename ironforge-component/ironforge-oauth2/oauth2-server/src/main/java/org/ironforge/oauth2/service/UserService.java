package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.repo.UserRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends IronforgeService<UserRepository, TUser, Integer> {
}
