package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TResourceTree;
import org.ironforge.oauth2.persist.repo.ResourceTreeRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class ResourceTreeService extends IronforgeService<ResourceTreeRepository, TResourceTree, Integer> {
    public int deleteByResourceCode(String resourceCode) {
        return repository.deleteByResourceCode(resourceCode);
    }
}
