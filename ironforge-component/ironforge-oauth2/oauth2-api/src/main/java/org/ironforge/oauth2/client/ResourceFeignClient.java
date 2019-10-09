package org.ironforge.oauth2.client;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.ResourceQuery;
import org.ironforge.oauth2.client.fallback.ResourceFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "oauth2", path = "/resource", fallbackFactory = ResourceFallbackFactory.class)
public interface ResourceFeignClient {

    @PostMapping("/add")
    /**
     * 新增一个资源
     * @param resource
     * @return
     */
    IronforgeResp<Resource> add(@RequestBody Resource resource);


    /**
     * 新增一个权限
     *
     * @param resource
     * @return
     */
    @PostMapping("/edit")
    IronforgeResp<Resource> edit(@RequestBody Resource resource);

    /**
     * 分页查询
     *
     * @param pageReq
     * @return
     */
    @PostMapping("/page")
    PageResp<Resource> pageQuery(PageReq<ResourceQuery> pageReq);

    /**
     * 根据ID查询role信息
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    IronforgeResp<Resource> findById(@PathVariable("id") Integer id);
}
