package org.ironforge.base.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.persist.entity.TMccDef;
import org.ironforge.base.persist.repo.MccRepository;
import org.ironforge.base.service.MccService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MccServiceImpl implements MccService {

    @Autowired
    private MccRepository mccRepository;

    @Override
    @Cacheable(key = "'base:mcc:'.concat(#p0)", cacheNames = "base:mcc")
    public TMccDef findByMccCode(String mccCode) {
        return mccRepository.findByMccCode(mccCode);
    }

    @Override
    @Cacheable(cacheNames = "base:mcc:full")
    public List<TMccDef> findAll() {
        return mccRepository.findAll();
    }
}
