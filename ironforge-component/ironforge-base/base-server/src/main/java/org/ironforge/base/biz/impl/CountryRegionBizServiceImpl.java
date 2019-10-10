package org.ironforge.base.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.biz.CountryRegionBizService;
import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.persist.entity.TCountryRegion;
import org.ironforge.base.service.CountryRegionService;
import org.ironforge.biz.BeanCopyBizService;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CountryRegionBizServiceImpl extends BeanCopyBizService<CountryRegionService, TCountryRegion, Integer, CountryRegion>
        implements CountryRegionBizService {


    public CountryRegionBizServiceImpl() {
        super(TCountryRegion.class, CountryRegion.class);
    }

    @Override
    public List<CountryRegion> findByCountryNumber(String countryNumber) {
        log.info("查询国家的地区国家数字码为:{}", countryNumber);
        List<TCountryRegion> tCountryRegionList =
                service.findByCountryNumber(countryNumber);
        List<CountryRegion> countryRegionList = this.batchTransferBO(tCountryRegionList);
        log.info("查询出来的地区列表为:{}", countryRegionList);
        return countryRegionList;
    }
}
