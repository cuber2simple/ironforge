package org.ironforge.base.biz;

import org.ironforge.base.bo.Country;

public interface CountryBizService {

  Country findByAlphaCode2(String alphaCode2);

  Country findByCountryCode3(String alphaCode3);

  Country findByCountryNumber(String countryNumber);
}
