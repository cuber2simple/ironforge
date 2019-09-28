package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.repo.ResourceRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class ResourceService extends IronforgeService<ResourceRepository, TResource, Integer> {
    public TResource findByResourceCode(String resourceCode) {
        return repository.findByResourceCode(resourceCode);
    }
}
