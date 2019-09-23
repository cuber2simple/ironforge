package org.ironforge.base.service;

import org.ironforge.base.persist.entity.TMccDef;

import java.util.List;

public interface MccService {
    TMccDef findByMccCode(String mccCode);

    List<TMccDef> findAll();
}
