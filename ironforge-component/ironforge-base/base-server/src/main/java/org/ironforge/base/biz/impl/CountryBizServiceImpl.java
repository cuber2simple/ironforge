package org.ironforge.base.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.biz.CountryBizService;
import org.ironforge.base.bo.Country;
import org.ironforge.base.persist.entity.TCountry3166;
import org.ironforge.base.service.CountryService;
import org.ironforge.transfer.BeanCopyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryBizServiceImpl extends BeanCopyTransfer<TCountry3166, Country>
    implements CountryBizService {

  @Autowired private CountryService countryService;

  public CountryBizServiceImpl() {
    super(TCountry3166.class, Country.class);
  }

  @Override
  public Country findByAlphaCode2(String alphaCode2) {
    log.info("接受国家查询的2字码为:{}", alphaCode2);
    TCountry3166 tCountry3166 = countryService.findByAlphaCode2(alphaCode2);
    Country country = this.entityTransferBO(tCountry3166);
    log.info("查询到的国家为:{}", country);
    return country;
  }

  @Override
  public Country findByAlphaCode3(String alphaCode3) {
    log.info("接受国家查询的3字码为:{}", alphaCode3);
    TCountry3166 tCountry3166 = countryService.findByAlphaCode3(alphaCode3);
    Country country = this.entityTransferBO(tCountry3166);
    log.info("查询到的国家为:{}", country);
    return country;
  }

  @Override
  public Country findByCountryNumber(String countryNumber) {
    log.info("接受国家查询的数字码为:{}", countryNumber);
    TCountry3166 tCountry3166 = countryService.findByCountryNumber(countryNumber);
    Country country = this.entityTransferBO(tCountry3166);
    log.info("查询到的国家为:{}", country);
    return country;
  }
}
