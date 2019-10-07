package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.entity.TResourceTree;
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

    @Autowired
    private ResourceTreeService resourceTreeService;

    @Test
    public void testInsertBaseResource() {
//
//        TResource index = new TResource();
//        index.setAvatar("index.jpg");
//        index.setIcon("index");
//        index.setNamespace("poss.ironforge.com");
//        index.setResourceCode("poss_index");
//        index.setResourceDesc("POSS首页");
//        index.setResourceName("首页");
//        index.setResourceType("menu");
//        index.setUrl("/index");
//        resourceService.save(index);
//
//        TResource order = new TResource();
//        order.setAvatar("order.jpg");
//        order.setIcon("order");
//        order.setNamespace("poss.ironforge.com");
//        order.setResourceCode("poss_order");
//        order.setResourceDesc("订单中心");
//        order.setResourceName("订单中心");
//        order.setResourceType("menu");
//        order.setUrl("/order");
//        resourceService.save(order);
//
//        TResource sale = new TResource();
//        sale.setAvatar("order_sale.jpg");
//        sale.setIcon("order_sale");
//        sale.setNamespace("poss.ironforge.com");
//        sale.setResourceCode("poss_order_sale");
//        sale.setResourceDesc("交易订单查询");
//        sale.setResourceName("交易订单");
//        sale.setResourceType("menu_page");
//        sale.setUrl("/order/sale");
//        resourceService.save(sale);
//
//        TResource auth = new TResource();
//        auth.setAvatar("order_auth.jpg");
//        auth.setIcon("order_auth");
//        auth.setNamespace("poss.ironforge.com");
//        auth.setResourceCode("poss_order_auth");
//        auth.setResourceDesc("预授权订单查询");
//        auth.setResourceName("预授权订单");
//        auth.setResourceType("menu_page");
//        auth.setUrl("/order/auth");
//        resourceService.save(auth);
//
//        TResource refund = new TResource();
//        refund.setAvatar("order_refund.jpg");
//        refund.setIcon("order_refund");
//        refund.setNamespace("poss.ironforge.com");
//        refund.setResourceCode("poss_order_refund");
//        refund.setResourceDesc("退款订单查询");
//        refund.setResourceName("退款订单");
//        refund.setResourceType("menu_page");
//        refund.setUrl("/order/refund");
//        resourceService.save(refund);
//
//        TResource chargeback = new TResource();
//        chargeback.setAvatar("order_chargeback.jpg");
//        chargeback.setIcon("order_chargeback");
//        chargeback.setNamespace("poss.ironforge.com");
//        chargeback.setResourceCode("poss_order_chargeback");
//        chargeback.setResourceDesc("拒付订单查询");
//        chargeback.setResourceName("拒付订单");
//        chargeback.setResourceType("menu_page");
//        chargeback.setUrl("/order/changeback");
//        resourceService.save(chargeback);
//
//        TResource channel = new TResource();
//        channel.setAvatar("channel.jpg");
//        channel.setIcon("channel");
//        channel.setNamespace("poss.ironforge.com");
//        channel.setResourceCode("poss_channel");
//        channel.setResourceDesc("渠道管理");
//        channel.setResourceName("渠道管理");
//        channel.setResourceType("menu");
//        channel.setUrl("/channel");
//        resourceService.save(channel);
//
//
//        TResource channelConf = new TResource();
//        channelConf.setAvatar("channel_config.jpg");
//        channelConf.setIcon("channel_config");
//        channelConf.setNamespace("poss.ironforge.com");
//        channelConf.setResourceCode("poss_channel_config");
//        channelConf.setResourceDesc("渠道配置");
//        channelConf.setResourceName("渠道配置");
//        channelConf.setResourceType("menu_page");
//        channelConf.setUrl("/channel/config");
//        resourceService.save(channelConf);
//
//        TResource kyc = new TResource();
//        kyc.setAvatar("sign_kyc.jpg");
//        kyc.setIcon("sign_kyc");
//        kyc.setNamespace("poss.ironforge.com");
//        kyc.setResourceCode("poss_channel_kyc");
//        kyc.setResourceDesc("签约进件");
//        kyc.setResourceName("签约进件");
//        kyc.setResourceType("menu_page");
//        kyc.setUrl("/channel/kyc");
//        resourceService.save(kyc);
//
//        TResourceTree tResourceTree = new TResourceTree();
//        tResourceTree.setResourceCode(index.getResourceCode());
//        tResourceTree.setSubResourceCode(order.getResourceCode());
//        tResourceTree.setSortIndex(0);
//        resourceTreeService.save(tResourceTree);
//
//
//        TResourceTree channelTree = new TResourceTree();
//        channelTree.setResourceCode(index.getResourceCode());
//        channelTree.setSubResourceCode(channel.getResourceCode());
//        channelTree.setSortIndex(1);
//        resourceTreeService.save(channelTree);
//
//
//        TResourceTree saleTree = new TResourceTree();
//        saleTree.setResourceCode(order.getResourceCode());
//        saleTree.setSubResourceCode(sale.getResourceCode());
//        saleTree.setSortIndex(0);
//        resourceTreeService.save(saleTree);
//
//
//
//        TResourceTree authTree = new TResourceTree();
//        authTree.setResourceCode(order.getResourceCode());
//        authTree.setSubResourceCode(auth.getResourceCode());
//        authTree.setSortIndex(1);
//        resourceTreeService.save(authTree);
//
//
//        TResourceTree refundTree = new TResourceTree();
//        refundTree.setResourceCode(order.getResourceCode());
//        refundTree.setSubResourceCode(refund.getResourceCode());
//        refundTree.setSortIndex(2);
//        resourceTreeService.save(refundTree);
//
//
//        TResourceTree changebackTree = new TResourceTree();
//        changebackTree.setResourceCode(order.getResourceCode());
//        changebackTree.setSubResourceCode(chargeback.getResourceCode());
//        changebackTree.setSortIndex(3);
//        resourceTreeService.save(changebackTree);
//
//
//        TResourceTree channelConfTree = new TResourceTree();
//        channelConfTree.setResourceCode(channel.getResourceCode());
//        channelConfTree.setSubResourceCode(channelConf.getResourceCode());
//        channelConfTree.setSortIndex(0);
//        resourceTreeService.save(channelConfTree);
//
//
//        TResourceTree kycTree = new TResourceTree();
//        kycTree.setResourceCode(order.getResourceCode());
//        kycTree.setSubResourceCode(kyc.getResourceCode());
//        kycTree.setSortIndex(1);
//        resourceTreeService.save(kycTree);
    }

    //@Test
    public void saleApi(){

        TResource trade_catalog = new TResource();
        trade_catalog.setAvatar("trade_catalog.jpg");
        trade_catalog.setIcon("trade_catalog");
        trade_catalog.setNamespace("");
        trade_catalog.setResourceCode("trade_catalog");
        trade_catalog.setResourceDesc("API总目录");
        trade_catalog.setResourceName("API总目录");
        trade_catalog.setResourceType("catalog");
        trade_catalog.setUrl("/acquire/catalog");
        resourceService.save(trade_catalog);

        TResource sale = new TResource();
        sale.setAvatar("sale.jpg");
        sale.setIcon("sale");
        sale.setNamespace("");
        sale.setResourceCode("trade_sale");
        sale.setResourceDesc("交易");
        sale.setResourceName("交易");
        sale.setResourceType("api");
        sale.setUrl("/acquire/sale");
        resourceService.save(sale);

        TResourceTree kycTree = new TResourceTree();
        kycTree.setResourceCode(trade_catalog.getResourceCode());
        kycTree.setSubResourceCode(sale.getResourceCode());
        kycTree.setSortIndex(1);
        resourceTreeService.save(kycTree);

        TResource auth = new TResource();
        auth.setAvatar("auth.jpg");
        auth.setIcon("auth");
        auth.setNamespace("");
        auth.setResourceCode("trade_auth");
        auth.setResourceDesc("预授权");
        auth.setResourceName("预授权");
        auth.setResourceType("api");
        auth.setUrl("/acquire/auth");
        resourceService.save(auth);

        TResourceTree authTree = new TResourceTree();
        authTree.setResourceCode(trade_catalog.getResourceCode());
        authTree.setSubResourceCode(auth.getResourceCode());
        authTree.setSortIndex(2);
        resourceTreeService.save(authTree);

        TResource capture = new TResource();
        capture.setAvatar("capture.jpg");
        capture.setIcon("capture");
        capture.setNamespace("");
        capture.setResourceCode("trade_capture");
        capture.setResourceDesc("预授权完成");
        capture.setResourceName("预授权完成");
        capture.setResourceType("api");
        capture.setUrl("/acquire/capture");
        resourceService.save(capture);

        TResourceTree captureTree = new TResourceTree();
        captureTree.setResourceCode(trade_catalog.getResourceCode());
        captureTree.setSubResourceCode(capture.getResourceCode());
        captureTree.setSortIndex(3);
        resourceTreeService.save(captureTree);

        TResource refund = new TResource();
        refund.setAvatar("refund.jpg");
        refund.setIcon("refund");
        refund.setNamespace("");
        refund.setResourceCode("trade_refund");
        refund.setResourceDesc("退款");
        refund.setResourceName("退款");
        refund.setResourceType("api");
        refund.setUrl("/acquire/refund");
        resourceService.save(refund);

        TResourceTree refundTree = new TResourceTree();
        refundTree.setResourceCode(trade_catalog.getResourceCode());
        refundTree.setSubResourceCode(refund.getResourceCode());
        refundTree.setSortIndex(4);
        resourceTreeService.save(refundTree);

        TResource authVoid = new TResource();
        authVoid.setAvatar("auth_void.jpg");
        authVoid.setIcon("auth_void");
        authVoid.setNamespace("");
        authVoid.setResourceCode("trade_auth_void");
        authVoid.setResourceDesc("预授权撤销");
        authVoid.setResourceName("预授权撤销");
        authVoid.setResourceType("api");
        authVoid.setUrl("/acquire/authVoid");
        resourceService.save(authVoid);

        TResourceTree authVoidTree = new TResourceTree();
        authVoidTree.setResourceCode(trade_catalog.getResourceCode());
        authVoidTree.setSubResourceCode(authVoid.getResourceCode());
        authVoidTree.setSortIndex(5);
        resourceTreeService.save(authVoidTree);

    }
}
