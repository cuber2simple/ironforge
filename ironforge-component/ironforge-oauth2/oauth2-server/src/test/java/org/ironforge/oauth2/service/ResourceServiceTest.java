package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.ironforge.oauth2.persist.entity.TResource;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Oauth2Application.class}) // 指定启动类
@Slf4j
public class ResourceServiceTest {

    @Autowired
    private ResourceService resourceService;

    public void testInsertBaseResource() {
        TResource index = new TResource();
        index.setAvatar("index.jpg");
        index.setIcon("index");
        index.setNamespace("poss.ironforge.com");
        index.setResourceCode("poss_index");
        index.setResourceDesc("POSS首页");
        index.setResourceName("首页");
        index.setResourceType("menu");
        index.setRoadMap("首页");
        resourceService.save(index);
        TResource resource = new TResource();
        resource.setAvatar("order.jpg");
        resource.setIcon("order");
        resource.setNamespace("poss.ironforge.com");
        resource.setResourceCode("poss_order");
        resource.setParentCode("poss_index");
        resource.setResourceDesc("订单中心");
        resource.setResourceName("订单中心");
        resource.setResourceType("menu");
        resource.setRoadMap("首页>>订单中心");
        resourceService.save(resource);
        resource = new TResource();
        resource.setAvatar("sale_order.jpg");
        resource.setIcon("sale_order");
        resource.setNamespace("poss.ironforge.com");
        resource.setResourceCode("poss_order_sale");
        resource.setParentCode("poss_order");
        resource.setResourceDesc("订单中心");
        resource.setResourceName("订单中心");
        resource.setResourceType("menu");
        resource.setRoadMap("首页>>订单中心");
        resourceService.save(resource);

    }
}
