package org.ironforge.base.biz;

import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.persist.entity.TCountryRegion;
import org.ironforge.biz.IronforgeBizService;

import java.util.List;

public interface CountryRegionBizService extends IronforgeBizService<CountryRegion, TCountryRegion,Integer> {
    List<CountryRegion> findByCountryNumber(String countryNumber);
}
