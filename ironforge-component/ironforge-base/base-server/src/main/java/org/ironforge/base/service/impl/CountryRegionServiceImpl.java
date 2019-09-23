package org.ironforge.base.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.persist.entity.TCountryRegion;
import org.ironforge.base.persist.repo.CountryRegionRepository;
import org.ironforge.base.service.CountryRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class CountryRegionServiceImpl implements CountryRegionService {
  @Autowired private CountryRegionRepository countryRegionRepository;

  @Override
  @Cacheable(key = "'base:country-region:'.concat(#p0)", cacheNames = "base:country-region")
  public List<TCountryRegion> findByCountryNumber(String countryNumber) {
    return countryRegionRepository.findByCountryNumber(countryNumber);
  }
}
