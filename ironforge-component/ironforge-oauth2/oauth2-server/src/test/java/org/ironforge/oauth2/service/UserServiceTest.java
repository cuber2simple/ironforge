package org.ironforge.oauth2.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.oauth2.Oauth2Application;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Oauth2Application.class}) // 指定启动类
@Slf4j
public class UserServiceTest {
}
