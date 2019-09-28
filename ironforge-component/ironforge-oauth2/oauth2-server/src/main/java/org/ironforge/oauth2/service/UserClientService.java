package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TUserClient;
import org.ironforge.oauth2.persist.repo.UserClientRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class UserClientService extends IronforgeService<UserClientRepository, TUserClient, Integer> {
}
