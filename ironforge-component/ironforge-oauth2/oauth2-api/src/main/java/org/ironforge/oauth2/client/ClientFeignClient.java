package org.ironforge.oauth2.client;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Client;
import org.ironforge.oauth2.bo.ClientQuery;
import org.ironforge.oauth2.client.fallback.ClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "oauth2", path = "/client", fallbackFactory = ClientFallbackFactory.class)
public interface ClientFeignClient {

    /**
     * 新增一个客户端
     *
     * @param client
     * @return
     */
    @PostMapping("/edit")
    IronforgeResp<Client> edit(@RequestBody Client client);

    /**
     * 分页查询
     *
     * @param pageReq
     * @return
     */
    @PostMapping("/page")
    PageResp<Client> pageQuery(PageReq<ClientQuery> pageReq);

    /**
     * 根据ID查询client信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    IronforgeResp<Client> findById(@PathVariable("id") Integer id);
}
