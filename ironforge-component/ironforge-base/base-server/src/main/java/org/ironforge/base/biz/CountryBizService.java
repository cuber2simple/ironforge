package org.ironforge.base.biz;

import org.ironforge.base.bo.Country;
import org.ironforge.biz.IronforgeBizService;

public interface CountryBizService extends IronforgeBizService<Country, Integer> {

    Country findByAlphaCode2(String alphaCode2);

    Country findByAlphaCode3(String alphaCode3);

    Country findByNumberCode(String countryNumber);
}
