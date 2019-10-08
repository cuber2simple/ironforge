package org.ironforge.oauth2.rest;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.bo.complex.GatewayUser;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.valid.anno.ValidCheck;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRest implements UserFeignClient {
}
