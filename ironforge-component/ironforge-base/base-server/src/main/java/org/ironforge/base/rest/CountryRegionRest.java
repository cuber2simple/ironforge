package org.ironforge.base.rest;

import org.ironforge.base.biz.CountryRegionBizService;
import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.client.CountryRegionFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/countryRegion")
public class CountryRegionRest implements CountryRegionFeignClient {

    @Autowired
    private CountryRegionBizService countryRegionBizService;
    @Override
    public IronforgeResp<List<CountryRegion>> findByCountryNumber(String countryNumber) {
        return IronforgeResp.success(countryRegionBizService.findByCountryNumber(countryNumber));
    }
}
