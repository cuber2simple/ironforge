package org.ironforge.base.biz;

import org.ironforge.base.model.CountryRegion;

import java.util.List;

public interface CountryRegionBizService {
  List<CountryRegion> findByCountryNumber(String countryNumber);
}
