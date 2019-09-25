package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.CardBin;
import org.ironforge.base.client.CardBinFeignClient;
import org.ironforge.bo.InvisibleCardBO;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardBinFallbackFactory extends IronforgeFallbackFactory<CardBinFeignClient> {
    @Override
    public CardBinFeignClient createFallback(IronforgeException ironforgeException) {
        return new CardBinFallback(ironforgeException);
    }

    class CardBinFallback implements CardBinFeignClient {

        private IronforgeException ironforgeException;

        public CardBinFallback(IronforgeException ironforgeException) {
            this.ironforgeException = ironforgeException;
        }

        @Override
        public IronforgeResp<CardBin> fetchBinInfo(InvisibleCardBO invisibleCardBO) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
