package org.ironforge.oauth2.client.fallback;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.bo.complex.GatewayUser;
import org.ironforge.oauth2.bo.complex.LoginAfterUser;
import org.ironforge.oauth2.client.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserFallbackFactory extends IronforgeFallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient createFallback(IronforgeException ironforgeException) {
        return new UserFallBack(ironforgeException);
    }

    class UserFallBack extends BaseFeignClientFallback implements UserFeignClient {

        public UserFallBack(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Token> login(Login login) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<GatewayUser> gateway() {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<LoginAfterUser> loginAfter() {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
