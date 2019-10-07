package org.ironforge.base.rest;

import org.ironforge.base.biz.CardBinBizService;
import org.ironforge.base.bo.CardBin;
import org.ironforge.base.client.CardBinFeignClient;
import org.ironforge.bo.InvisibleCardBO;
import org.ironforge.bo.IronforgeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cardbin")
public class CardBinRest implements CardBinFeignClient {

    @Autowired
    private CardBinBizService cardBinBizService;

    @Override
    public IronforgeResp<CardBin> fetchBinInfo(InvisibleCardBO invisibleCardBO) {
        return IronforgeResp.success(cardBinBizService.findByCardNo(invisibleCardBO));
    }
}
