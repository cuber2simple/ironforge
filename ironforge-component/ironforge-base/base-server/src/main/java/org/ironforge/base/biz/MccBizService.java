package org.ironforge.base.biz;

import org.ironforge.base.bo.Mcc;
import org.ironforge.biz.IronforgeBizService;

import java.util.List;

public interface MccBizService extends IronforgeBizService<Mcc, Integer> {
    Mcc findByMccCode(String mccCode);

    List<Mcc> findAll();
}
