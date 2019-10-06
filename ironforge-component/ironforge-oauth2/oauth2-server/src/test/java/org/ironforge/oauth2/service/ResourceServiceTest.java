package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.ironforge.oauth2.persist.entity.TResource;
import org.junit.Test;
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

    @Test
    public void testInsertBaseResource() {

        TResource index = new TResource();
        index.setAvatar("index.jpg");
        index.setIcon("index");
        index.setNamespace("poss.ironforge.com");
        index.setResourceCode("poss_index");
        index.setResourceDesc("POSS首页");
        index.setResourceName("首页");
        index.setResourceType("menu");
        index.setUrl("/index");
        resourceService.save(index);

        TResource order = new TResource();
        order.setAvatar("order.jpg");
        order.setIcon("order");
        order.setNamespace("poss.ironforge.com");
        order.setResourceCode("poss_order");
        order.setResourceDesc("订单中心");
        order.setResourceName("订单中心");
        order.setResourceType("menu");
        order.setUrl("/order");
        resourceService.save(order);

        TResource sale = new TResource();
        sale.setAvatar("order_sale.jpg");
        sale.setIcon("order_sale");
        sale.setNamespace("poss.ironforge.com");
        sale.setResourceCode("poss_order_sale");
        sale.setResourceDesc("交易订单查询");
        sale.setResourceName("交易订单");
        sale.setResourceType("menu");
        sale.setUrl("/order/sale");
        resourceService.save(sale);

        TResource auth = new TResource();
        auth.setAvatar("order_auth.jpg");
        auth.setIcon("order_auth");
        auth.setNamespace("poss.ironforge.com");
        auth.setResourceCode("poss_order_auth");
        auth.setResourceDesc("预授权订单查询");
        auth.setResourceName("预授权订单");
        auth.setResourceType("menu");
        auth.setUrl("/order/auth");
        resourceService.save(auth);

        TResource refund = new TResource();
        refund.setAvatar("order_refund.jpg");
        refund.setIcon("order_refund");
        refund.setNamespace("poss.ironforge.com");
        refund.setResourceCode("poss_order_refund");
        refund.setResourceDesc("退款订单查询");
        refund.setResourceName("退款订单");
        refund.setResourceType("menu");
        refund.setUrl("/order/refund");
        resourceService.save(refund);

        TResource chargeback = new TResource();
        chargeback.setAvatar("order_chargeback.jpg");
        chargeback.setIcon("order_chargeback");
        chargeback.setNamespace("poss.ironforge.com");
        chargeback.setResourceCode("poss_order_chargeback");
        chargeback.setResourceDesc("拒付订单查询");
        chargeback.setResourceName("拒付订单");
        chargeback.setResourceType("menu");
        chargeback.setUrl("/order/changeback");
        resourceService.save(chargeback);

        TResource channel = new TResource();
        channel.setAvatar("channel.jpg");
        channel.setIcon("channel");
        channel.setNamespace("poss.ironforge.com");
        channel.setResourceCode("poss_channel");
        channel.setResourceDesc("渠道管理");
        channel.setResourceName("渠道管理");
        channel.setResourceType("menu");
        chargeback.setUrl("/channel");
        resourceService.save(channel);


        TResource channelConf = new TResource();
        channelConf.setAvatar("channel_config.jpg");
        channelConf.setIcon("channel_config");
        channelConf.setNamespace("poss.ironforge.com");
        channelConf.setResourceCode("poss_channel_config");
        channelConf.setResourceDesc("渠道配置");
        channelConf.setResourceName("渠道配置");
        channelConf.setResourceType("menu");
        chargeback.setUrl("/channel/config");
        resourceService.save(channelConf);

        TResource kyc = new TResource();
        kyc.setAvatar("sign_kyc.jpg");
        kyc.setIcon("sign_kyc");
        kyc.setNamespace("poss.ironforge.com");
        kyc.setResourceCode("poss_channel_kyc");
        kyc.setResourceDesc("签约进件");
        kyc.setResourceName("签约进件");
        kyc.setResourceType("menu");
        resourceService.save(channelConf);


    }
}
