package org.ironforge.base.biz;

import org.ironforge.base.bo.CountryRegion;

import java.util.List;

public interface CountryRegionBizService {
  List<CountryRegion> findByCountryNumber(String countryNumber);
}
