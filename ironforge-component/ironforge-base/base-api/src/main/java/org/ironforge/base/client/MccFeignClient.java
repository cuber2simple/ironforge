package org.ironforge.base.client;

import org.ironforge.base.bo.Mcc;
import org.ironforge.base.client.fallback.MccFallbackFactory;
import org.ironforge.bo.IronforgeResp;
import org.springframework.cloud.openfeign.FeignClient;

import java.util.List;

@FeignClient(name = "base", path = "/mcc", fallbackFactory = MccFallbackFactory.class)
public interface MccFeignClient {
    IronforgeResp<Mcc> findByMccCode(String mccCode);

    IronforgeResp<List<Mcc>> findAll();
}
