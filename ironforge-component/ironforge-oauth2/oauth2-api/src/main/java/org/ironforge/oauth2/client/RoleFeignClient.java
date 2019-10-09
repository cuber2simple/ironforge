package org.ironforge.oauth2.client;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.oauth2.bo.Client;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;
import org.ironforge.oauth2.client.fallback.RoleFallbackFactory;
import org.ironforge.oauth2.client.fallback.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "oauth2", path = "/role", fallbackFactory = RoleFallbackFactory.class)
public interface RoleFeignClient {
    @PostMapping("/add")
    /**
     * 新增一个权限
     * @param role
     * @return
     */
    IronforgeResp<Role> add(@RequestBody Role role);


    /**
     * 新增一个权限
     *
     * @param role
     * @return
     */
    @PostMapping("/edit")
    IronforgeResp<Role> edit(@RequestBody Role role);

    /**
     * 分页查询
     *
     * @param pageReq
     * @return
     */
    @PostMapping("/page")
    PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq);

    /**
     * 根据ID查询role信息
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    IronforgeResp<Role> findById(@PathVariable("id") Integer id);

    /**
     * 设置该角色拥有的资源
     *
     * @param roleCode
     * @param resources
     * @return
     */
    @PostMapping("/{roleCode}/resource/set")
    IronforgeResp<Boolean> resetRole(@PathVariable("roleCode") String roleCode, @RequestBody List<String> resources);

    /**
     * 查找该角色下所有的资源
     *
     * @param roleCode
     * @return
     */
    @GetMapping("/{roleCode}/role")
    IronforgeResp<List<Resource>> roles(@PathVariable("roleCode") String roleCode);

}
