package org.ironforge.base.client;

import org.ironforge.base.bo.CardBin;
import org.ironforge.bo.InvisibleCardBO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "ironforge-base", path = "/cardbin")
public interface CardBinFeignClient {

    @GetMapping("/fetchBinInfo")
    CardBin fetchBinInfo(InvisibleCardBO invisibleCardBO);
}
