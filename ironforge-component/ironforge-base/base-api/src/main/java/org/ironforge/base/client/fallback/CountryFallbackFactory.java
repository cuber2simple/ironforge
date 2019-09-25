package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.client.CountryFeignClient;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CountryFallbackFactory extends IronforgeFallbackFactory<CountryFeignClient> {
    @Override
    public CountryFeignClient createFallback(IronforgeException ironforgeException) {
        return null;
    }
}
