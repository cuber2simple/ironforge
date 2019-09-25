package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.Country;
import org.ironforge.base.client.CountryFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CountryFallbackFactory extends IronforgeFallbackFactory<CountryFeignClient> {
    @Override
    public CountryFeignClient createFallback(IronforgeException ironforgeException) {
        return new CountryFallback(ironforgeException);
    }

    class CountryFallback implements CountryFeignClient {

        private IronforgeException ironforgeException;

        public CountryFallback(IronforgeException ironforgeException) {
            this.ironforgeException = ironforgeException;
        }
        @Override
        public IronforgeResp<Country> findByAlphaCode2(String alphaCode2) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Country> findByCountryCode3(String alphaCode3) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Country> findByCountryNumber(String countryNumber) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
