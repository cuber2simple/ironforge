package org.ironforge.base.rest;

import org.ironforge.base.biz.MccBizService;
import org.ironforge.base.bo.Mcc;
import org.ironforge.base.client.MccFeignClient;
import org.ironforge.bo.IronforgeResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/mcc")
public class MccRest implements MccFeignClient {

    @Autowired
    private MccBizService mccBizService;
    @Override
    public IronforgeResp<Mcc> findByMccCode(String mccCode) {
        return IronforgeResp.success(mccBizService.findByMccCode(mccCode));
    }

    @Override
    public IronforgeResp<List<Mcc>> findAll() {
        return IronforgeResp.success(mccBizService.findAll());
    }
}
