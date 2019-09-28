package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TGroup;
import org.ironforge.oauth2.persist.repo.GroupRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class GroupService extends IronforgeService<GroupRepository, TGroup, Integer> {
}
