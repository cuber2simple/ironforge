package org.ironforge.base.client;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ironforge-base", path = "/countryRegion")
public interface CountryRegionFeignClient {
}
