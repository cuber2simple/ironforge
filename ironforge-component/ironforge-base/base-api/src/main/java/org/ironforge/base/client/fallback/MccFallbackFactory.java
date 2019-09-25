package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.client.MccFeignClient;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MccFallbackFactory extends IronforgeFallbackFactory<MccFeignClient> {
    @Override
    public MccFeignClient createFallback(IronforgeException ironforgeException) {
        return null;
    }
}
