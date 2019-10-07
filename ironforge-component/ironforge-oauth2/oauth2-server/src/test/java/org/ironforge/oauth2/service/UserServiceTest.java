package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.entity.TUserClient;
import org.ironforge.oauth2.persist.entity.TUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Oauth2Application.class}) // 指定启动类
@Slf4j
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private UserClientService userClientService;

    //@Test
    public void testInsert() {
        TUser tUser = new TUser();
        tUser.setMerchantId("15600000001");
        tUser.setPassword("12345678");
        tUser.setEmail("cuber.carrots@gmail.com");
        tUser.setNickName("cuber");
        tUser.setUserName("cuber");
        tUser.setUserType("operator");
        tUser.setPhone("13248199190");
        userService.save(tUser);

        TUser orderOp = new TUser();
        orderOp.setMerchantId("15600000001");
        orderOp.setPassword("12345678");
        orderOp.setEmail("nico.li@gmail.com");
        orderOp.setNickName("nico");
        orderOp.setUserName("nico");
        orderOp.setUserType("operator");
        orderOp.setPhone("13248199191");
        userService.save(orderOp);

        TUser channelOp = new TUser();
        channelOp.setMerchantId("15600000001");
        channelOp.setPassword("12345678");
        channelOp.setEmail("faker.li@gmail.com");
        channelOp.setNickName("faker");
        channelOp.setUserName("faker");
        channelOp.setUserType("operator");
        channelOp.setPhone("13248199192");
        userService.save(channelOp);
    }

    //@Test
    public void insertUserRole() {
        TUserRole tUserRole = new TUserRole();
        tUserRole.setUserId("1560000000100000002");
        tUserRole.setRoleCode("rol e_order");
        userRoleService.save(tUserRole);

        TUserRole tUserRole1 = new TUserRole();
        tUserRole1.setUserId("1560000000100000002");
        tUserRole1.setRoleCode("role_user");
        userRoleService.save(tUserRole1);

        TUserRole tUserRole2 = new TUserRole();
        tUserRole2.setUserId("1560000000100000003");
        tUserRole2.setRoleCode("role_channel");
        userRoleService.save(tUserRole2);

        TUserRole tUserRole3 = new TUserRole();
        tUserRole3.setUserId("1560000000100000003");
        tUserRole3.setRoleCode("role_user");
        userRoleService.save(tUserRole3);
    }

    //@Test
    public void insertUserClient() {
        TUser clientIdUserId = new TUser();
        clientIdUserId.setMerchantId("15600000002");
        clientIdUserId.setPassword("12345678");
        clientIdUserId.setEmail("client_1.poss@gmail.com");
        clientIdUserId.setNickName("client_1_merchant");
        clientIdUserId.setUserName("client_1_merchant");
        clientIdUserId.setUserType("client");
        clientIdUserId.setPhone("13248199195");
        userService.save(clientIdUserId);

        TUserClient tUserClient = new TUserClient();
        tUserClient.setUserId(clientIdUserId.getUserId());
        userClientService.save(tUserClient);

        TUser clientIdUserId1 = new TUser();
        clientIdUserId1.setMerchantId("15600000003");
        clientIdUserId1.setPassword("12345678");
        clientIdUserId1.setEmail("client_2.poss@gmail.com");
        clientIdUserId1.setNickName("client_2_merchant");
        clientIdUserId1.setUserName("client_2_merchant");
        clientIdUserId1.setUserType("client");
        clientIdUserId1.setPhone("13248199196");
        userService.save(clientIdUserId1);

        TUserClient tUserClient1 = new TUserClient();
        tUserClient1.setUserId(clientIdUserId1.getUserId());
        userClientService.save(tUserClient1);
    }

    @Test
    public void insertUserRoleApi(){
//        TUserRole tUserRole2 = new TUserRole();
//        tUserRole2.setUserId("1560000000299999999");
//        tUserRole2.setRoleCode("role_api_trade");
//        userRoleService.save(tUserRole2);
    }


}
