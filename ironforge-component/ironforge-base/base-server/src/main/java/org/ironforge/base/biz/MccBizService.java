package org.ironforge.base.biz;

import org.ironforge.base.model.Mcc;
import org.ironforge.base.persist.entity.TMccDef;

import java.util.List;

public interface MccBizService {
    Mcc findByMccCode(String mccCode);

    List<Mcc> findAll();
}
