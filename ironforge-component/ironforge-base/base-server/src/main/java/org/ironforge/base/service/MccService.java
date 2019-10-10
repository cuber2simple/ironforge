package org.ironforge.base.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.persist.entity.TMccDef;
import org.ironforge.base.persist.repo.MccRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class MccService extends IronforgeService<MccRepository, TMccDef, Integer> {
    public TMccDef findByMccCode(String mccCode) {
        return repository.findByMccCode(mccCode);
    }

    public List<TMccDef> findAll() {
        return repository.findAll();
    }
}
