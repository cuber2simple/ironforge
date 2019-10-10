package org.ironforge.base.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.biz.CountryBizService;
import org.ironforge.base.bo.Country;
import org.ironforge.base.persist.entity.TCountry3166;
import org.ironforge.base.service.CountryService;
import org.ironforge.biz.BeanCopyBizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryBizServiceImpl extends BeanCopyBizService<CountryService, TCountry3166, Integer, Country>
        implements CountryBizService {


    public CountryBizServiceImpl() {
        super(TCountry3166.class, Country.class);
    }

    @Override
    public Country findByAlphaCode2(String alphaCode2) {
        return entityTransferBO(service.findByAlphaCode2(alphaCode2));
    }

    @Override
    public Country findByAlphaCode3(String alphaCode3) {
      return entityTransferBO(service.findByAlphaCode3(alphaCode3));
    }

    @Override
    public Country findByNumberCode(String numberCode) {
      return entityTransferBO(service.findByNumberCode(numberCode));
    }
}
