package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.Mcc;
import org.ironforge.base.client.MccFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Slf4j
public class MccFallbackFactory extends IronforgeFallbackFactory<MccFeignClient> {
    @Override
    public MccFeignClient createFallback(IronforgeException ironforgeException) {
        return new MccFallback(ironforgeException);
    }

    class MccFallback implements MccFeignClient {
        private IronforgeException ironforgeException;

        public MccFallback(IronforgeException ironforgeException) {
            this.ironforgeException = ironforgeException;
        }

        @Override
        public IronforgeResp<Mcc> findByMccCode(String mccCode) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<List<Mcc>> findAll() {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
