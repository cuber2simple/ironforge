package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.CardBin;
import org.ironforge.base.client.CardBinFeignClient;
import org.ironforge.bo.InvisibleCardBO;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardBinFallbackFactory extends IronforgeFallbackFactory<CardBinFeignClient> {
    @Override
    public CardBinFeignClient createFallback(IronforgeException ironforgeException) {
        return new CardBinFallback(ironforgeException);
    }

    class CardBinFallback extends BaseFeignClientFallback implements CardBinFeignClient {

        public CardBinFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<CardBin> fetchBinInfo(InvisibleCardBO invisibleCardBO) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
