package org.ironforge.base.rest;

import org.ironforge.base.biz.CountryBizService;
import org.ironforge.base.bo.Country;
import org.ironforge.base.client.CountryFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/country")
public class CountryRest implements CountryFeignClient {
    @Autowired
    private CountryBizService countryBizService;

    @Override
    public IronforgeResp<Country> findByAlphaCode2(String alphaCode2) {
        return IronforgeResp.success(countryBizService.findByAlphaCode2(alphaCode2));
    }

    @Override
    public IronforgeResp<Country> findByAlphaCode3(String alphaCode3) {
        return IronforgeResp.success(countryBizService.findByAlphaCode3(alphaCode3));
    }

    @Override
    public IronforgeResp<Country> findByCountryNumber(String numberCode) {
        return IronforgeResp.success(countryBizService.findByNumberCode(numberCode));
    }
}
