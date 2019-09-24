package org.ironforge.base.biz;

import org.ironforge.base.bo.Mcc;

import java.util.List;

public interface MccBizService {
    Mcc findByMccCode(String mccCode);

    List<Mcc> findAll();
}
