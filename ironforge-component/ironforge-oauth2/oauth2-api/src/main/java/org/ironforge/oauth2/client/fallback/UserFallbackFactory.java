package org.ironforge.oauth2.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.oauth2.client.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallbackFactory extends IronforgeResp<UserFeignClient> {
}
