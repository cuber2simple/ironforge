package org.ironforge.base.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.bo.CardBin;
import org.ironforge.base.client.CardBinFeignClient;
import org.ironforge.bo.InvisibleCardBO;
import org.ironforge.constants.IronforgeCode;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CardBinFallbackFactory extends IronforgeFallbackFactory<CardBinFeignClient> {
    @Override
    public CardBinFeignClient createFallback(IronforgeException ironforgeException) {
        return null;
    }

    class CardBinFeignClientFallback implements CardBinFeignClient {

        private IronforgeException ironforgeException;

        public CardBinFeignClientFallback(IronforgeException ironforgeException) {
            this.ironforgeException = ironforgeException;
        }

        @Override
        public CardBin fetchBinInfo(InvisibleCardBO invisibleCardBO) {
            IronforgeCode ironforgeCode = ironforgeException.retrieve();
            CardBin cardBin = CardBin.status(ironforgeCode, CardBin.class);
            cardBin.setMsg(ironforgeException.getMessage());
            return cardBin;
        }
    }
}
