package org.ironforge.oauth2.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.ironforge.biz.BeanCopyBizService;
import org.ironforge.oauth2.biz.ResourceBizService;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.entity.TResourceTree;
import org.ironforge.oauth2.service.ResourceService;
import org.ironforge.oauth2.service.ResourceTreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class ResourceBizServiceImpl extends BeanCopyBizService<ResourceService, TResource, Integer, Resource> implements ResourceBizService {

    @Autowired
    private ResourceTreeService resourceTreeService;

    public ResourceBizServiceImpl() {
        super(TResource.class, Resource.class);
    }

    @Override
    public List<Resource> findSubElements(String resourceCode) {
        List<TResource> subElements = service.findSubElements(resourceCode);
        return batchTransferBO(subElements);
    }

    @Override
    @Transactional
    public boolean resetSubElements(String resourceCode, List<String> resourceCodes) {
        resourceTreeService.deleteByResourceCode(resourceCode);
        if (CollectionUtils.isNotEmpty(resourceCodes)) {
            List<TResourceTree> tResourceTreeList = resourceCodes
                    .stream().map(code -> instance(resourceCode, code)).collect(Collectors.toList());
            resourceTreeService.saveAll(tResourceTreeList);
        }
        return true;
    }

    @Override
    public List<Resource> findSubElements(String resourceCode, String userId) {
        return null;
    }


    public static TResourceTree instance(String resourceCode, String code) {
        return new TResourceTree(resourceCode, code);
    }




}
