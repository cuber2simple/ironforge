package org.ironforge.base.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.persist.entity.TCountry3166;
import org.ironforge.base.persist.repo.CountryRepository;
import org.ironforge.base.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CountryServiceImpl implements CountryService {

  @Autowired private CountryRepository countryRepository;

  @Override
  @Cacheable(key = "'base:country:'.concat(#p0)", cacheNames = "base:country")
  public TCountry3166 findByAlphaCode2(String alphaCode2) {
    return countryRepository.findByAlphaCode2(alphaCode2);
  }

  @Override
  @Cacheable(key = "'base:country:'.concat(#p0)", cacheNames = "base:country")
  public TCountry3166 findByCountryCode3(String alphaCode3) {
    return countryRepository.findByAlphaCode3(alphaCode3);
  }

  @Override
  @Cacheable(key = "'base:country:'.concat(#p0)", cacheNames = "base:country")
  public TCountry3166 findByCountryNumber(String countryNumber) {
    return countryRepository.findByNumberCode(countryNumber);
  }
}
