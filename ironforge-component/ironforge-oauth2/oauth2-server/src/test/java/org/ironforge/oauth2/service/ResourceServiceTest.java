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
        resource.setAvatar("order_sale.jpg");
        resource.setIcon("order_sale");
        resource.setNamespace("poss.ironforge.com");
        resource.setResourceCode("poss_order_sale");
        resource.setParentCode("poss_order");
        resource.setResourceDesc("交易订单查询");
        resource.setResourceName("交易订单");
        resource.setResourceType("menu");
        resource.setSortIndex(1);
        resource.setRoadMap("首页>>订单中心>>交易订单");
        resourceService.save(resource);
        resource = new TResource();
        resource.setAvatar("order_auth.jpg");
        resource.setIcon("order_auth");
        resource.setNamespace("poss.ironforge.com");
        resource.setResourceCode("poss_order_auth");
        resource.setParentCode("poss_order");
        resource.setResourceDesc("预授权订单查询");
        resource.setResourceName("预授权订单");
        resource.setSortIndex(2);
        resource.setResourceType("menu");
        resource.setRoadMap("首页>>订单中心>>预授权订单");
        resourceService.save(resource);
        resource = new TResource();
        resource.setAvatar("order_refund.jpg");
        resource.setIcon("order_refund");
        resource.setNamespace("poss.ironforge.com");
        resource.setResourceCode("poss_order_refund");
        resource.setParentCode("poss_order");
        resource.setResourceDesc("退款订单查询");
        resource.setResourceName("退款订单");
        resource.setSortIndex(3);
        resource.setResourceType("menu");
        resource.setRoadMap("首页>>订单中心>>退款订单");
        resourceService.save(resource);

    }
}
