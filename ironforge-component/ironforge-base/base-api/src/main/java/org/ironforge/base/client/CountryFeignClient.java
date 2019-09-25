package org.ironforge.base.client;

import org.ironforge.base.bo.Country;
import org.ironforge.base.client.fallback.CountryFallbackFactory;
import org.ironforge.bo.IronforgeResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "ironforge-base", path = "/country", fallbackFactory = CountryFallbackFactory.class)
public interface CountryFeignClient {
    @GetMapping("/alphacode2/{alphaCode2}")
    IronforgeResp<Country> findByAlphaCode2(@PathVariable("alphaCode2") String alphaCode2);

    @GetMapping("/alphacode3/{alphaCode3}")
    IronforgeResp<Country> findByAlphaCode3(@PathVariable("alphaCode3") String alphaCode3);

    @GetMapping("/countryNumber/{countryNumber}")
    IronforgeResp<Country> findByCountryNumber(@PathVariable("countryNumber") String countryNumber);
}
