package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.ironforge.oauth2.persist.entity.TResourceRole;
import org.ironforge.oauth2.persist.entity.TRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Oauth2Application.class}) // 指定启动类
@Slf4j
public class RoleServiceTest {

    @Autowired
    private RoleService roleService;

    @Autowired
    private ResourceRoleService resourceRoleService;

    @Test
    public void testInsert(){
        TRole tRole = new TRole();
        tRole.setNamespace("poss.ironforge.com");
        tRole.setSuperManager("true");
        tRole.setRoleCode("root");
        tRole.setRoleName("超级管理员");
        tRole.setRoleDesc("超级管理员组，不可删除");
        roleService.save(tRole);

        TRole orderRule = new TRole();
        orderRule.setNamespace("poss.ironforge.com");
        orderRule.setSuperManager("false");
        orderRule.setRoleCode("role_order");
        orderRule.setRoleName("订单组权限");
        orderRule.setRoleDesc("订单组权限");
        roleService.save(orderRule);

        TRole channelRule = new TRole();
        channelRule.setNamespace("poss.ironforge.com");
        channelRule.setSuperManager("false");
        channelRule.setRoleCode("role_channel");
        channelRule.setRoleName("渠道组权限");
        channelRule.setRoleDesc("渠道组权限");
        roleService.save(channelRule);

        TRole user = new TRole();
        user.setNamespace("poss.ironforge.com");
        user.setSuperManager("false");
        user.setRoleCode("role_user");
        user.setRoleName("普通用户权限");
        user.setRoleDesc("普通用户权限");
        roleService.save(user);

        TResourceRole tResourceRole = new TResourceRole();
        tResourceRole.setRoleCode(user.getRoleCode());
        tResourceRole.setResourceCode("index");
        resourceRoleService.save(tResourceRole);

        TResourceRole orderRole = new TResourceRole();
        orderRole.setRoleCode(orderRule.getRoleCode());
        orderRole.setResourceCode("poss_channel");
        resourceRoleService.save(orderRole);

        TResourceRole saleRole = new TResourceRole();
        saleRole.setRoleCode(orderRule.getRoleCode());
        saleRole.setResourceCode("poss_order_sale");
        resourceRoleService.save(saleRole);

        TResourceRole authRole = new TResourceRole();
        authRole.setRoleCode(orderRule.getRoleCode());
        authRole.setResourceCode("poss_order_auth");
        resourceRoleService.save(authRole);

        TResourceRole refundRole = new TResourceRole();
        refundRole.setRoleCode(orderRule.getRoleCode());
        refundRole.setResourceCode("poss_order_refund");
        resourceRoleService.save(refundRole);

        TResourceRole changebackRole = new TResourceRole();
        changebackRole.setRoleCode(orderRule.getRoleCode());
        changebackRole.setResourceCode("poss_order_chargeback");
        resourceRoleService.save(changebackRole);

        TResourceRole channelRole = new TResourceRole();
        channelRole.setRoleCode(channelRule.getRoleCode());
        channelRole.setResourceCode("poss_channel");
        resourceRoleService.save(channelRole);

        TResourceRole channelConfRole = new TResourceRole();
        channelConfRole.setRoleCode(channelRule.getRoleCode());
        channelConfRole.setResourceCode("poss_channel_config");
        resourceRoleService.save(channelConfRole);

        TResourceRole kycRole = new TResourceRole();
        kycRole.setRoleCode(channelRule.getRoleCode());
        kycRole.setResourceCode("poss_channel_kyc");
        resourceRoleService.save(kycRole);
    }

    @Test
    public void insertApiRule(){
//        TRole tRole = new TRole();
//        tRole.setNamespace("");
//        tRole.setSuperManager("false");
//        tRole.setRoleCode("role_api_trade");
//        tRole.setRoleName("role_api_trade");
//        tRole.setRoleDesc("api权限，交易相关");
//        roleService.save(tRole);
//
//        TResourceRole tResourceRole = new TResourceRole();
//        tResourceRole.setRoleCode(tRole.getRoleCode());
//        tResourceRole.setResourceCode("trade_sale");
//        resourceRoleService.save(tResourceRole);
//
//        TResourceRole tResourceRole1 = new TResourceRole();
//        tResourceRole1.setRoleCode(tRole.getRoleCode());
//        tResourceRole1.setResourceCode("trade_auth");
//        resourceRoleService.save(tResourceRole1);
//
//        TResourceRole tResourceRole2 = new TResourceRole();
//        tResourceRole2.setRoleCode(tRole.getRoleCode());
//        tResourceRole2.setResourceCode("trade_capture");
//        resourceRoleService.save(tResourceRole2);

//        TResourceRole tResourceRole4 = new TResourceRole();
//        tResourceRole4.setRoleCode("role_api_trade");
//        tResourceRole4.setResourceCode("trade_refund");
//        resourceRoleService.save(tResourceRole4);
//
//        TResourceRole tResourceRole5 = new TResourceRole();
//        tResourceRole5.setRoleCode("role_api_trade");
//        tResourceRole5.setResourceCode("trade_auth_void");
//        resourceRoleService.save(tResourceRole5);
    }
}
