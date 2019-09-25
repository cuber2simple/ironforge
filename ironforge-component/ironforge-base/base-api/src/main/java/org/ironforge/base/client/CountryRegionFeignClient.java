package org.ironforge.base.client;

import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.client.fallback.CountryRegionFallbackFactory;
import org.ironforge.bo.IronforgeResp;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "ironforge-base", path = "/countryRegion", fallbackFactory = CountryRegionFallbackFactory.class)
public interface CountryRegionFeignClient {

    IronforgeResp<List<CountryRegion>> findByCountryNumber(String countryNumber);

}
