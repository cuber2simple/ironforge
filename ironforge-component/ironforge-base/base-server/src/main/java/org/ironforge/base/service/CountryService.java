package org.ironforge.base.service;

import org.ironforge.base.persist.entity.TCountry3166;

public interface CountryService {

  TCountry3166 findByAlphaCode2(String alphaCode2);

  TCountry3166 findByCountryCode3(String alphaCode3);

  TCountry3166 findByCountryNumber(String countryNumber);
}
