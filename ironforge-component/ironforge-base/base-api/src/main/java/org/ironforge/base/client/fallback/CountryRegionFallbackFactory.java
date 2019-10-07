package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.CountryRegion;
import org.ironforge.base.client.CountryRegionFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class CountryRegionFallbackFactory extends IronforgeFallbackFactory<CountryRegionFeignClient> {
    @Override
    public CountryRegionFeignClient createFallback(IronforgeException ironforgeException) {
        return new CountryRegionFallback(ironforgeException);
    }

    class CountryRegionFallback extends BaseFeignClientFallback implements CountryRegionFeignClient {
        public CountryRegionFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<List<CountryRegion>> findByCountryNumber(String countryNumber) {
            return new IronforgeResp<>(ironforgeException);
        }
    }

}
