package org.ironforge.oauth2.client;

import org.ironforge.oauth2.client.fallback.UserFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "ironforge-oauth2", path = "/user", fallbackFactory = UserFallbackFactory.class)
public interface UserFeignClient {

}
