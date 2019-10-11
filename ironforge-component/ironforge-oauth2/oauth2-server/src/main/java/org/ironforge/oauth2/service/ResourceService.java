package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.repo.ResourceRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService extends IronforgeService<ResourceRepository, TResource, Integer> {

    public TResource findByResourceCode(String resourceCode) {
        return repository.findByResourceCode(resourceCode);
    }

    public List<TResource> findSubElements(String resourceCode) {
        return repository.findSubElements(resourceCode);
    }

}
