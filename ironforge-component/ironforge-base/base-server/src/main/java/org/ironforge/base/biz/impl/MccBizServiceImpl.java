package org.ironforge.base.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.biz.CountryRegionBizService;
import org.ironforge.base.biz.MccBizService;
import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.bo.Mcc;
import org.ironforge.base.persist.entity.TCountryRegion;
import org.ironforge.base.persist.entity.TMccDef;
import org.ironforge.base.service.MccService;
import org.ironforge.transfer.BeanCopyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class MccBizServiceImpl extends BeanCopyTransfer<TMccDef, Mcc> implements MccBizService {
  @Autowired private MccService mccService;

  public MccBizServiceImpl() {
    super(TMccDef.class, Mcc.class);
  }

  @Override
  public Mcc findByMccCode(String mccCode) {
    log.info("查询行业的参数为:{}", mccCode);
    TMccDef tMccDef = mccService.findByMccCode(mccCode);
    Mcc mcc = this.entityTransferBO(tMccDef);
    log.info("查询出来的行业为:{}", mcc);
    return mcc;
  }

  @Override
  public List<Mcc> findAll() {
    log.info("开始查询全部的行业类型");
    List<TMccDef> tMccDefList = mccService.findAll();
    List<Mcc> mccList = this.batchTransferBO(tMccDefList);
    log.info("查询出来的参数为:{}", mccList);
    return mccList;
  }
}
