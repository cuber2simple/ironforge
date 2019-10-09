package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.Token;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.ClientLogin;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.oauth2.bo.complex.GatewayUser;
import org.ironforge.oauth2.client.TokenFeignClient;

public class TokenFallbackFactory extends IronforgeFallbackFactory<TokenFeignClient> {
    @Override
    public TokenFeignClient createFallback(IronforgeException ironforgeException) {
        return new TokenFallback(ironforgeException);
    }

    class TokenFallback extends BaseFeignClientFallback implements TokenFeignClient {

        public TokenFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Token> login(Login login) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<GatewayUser> fetch(String token) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Token> app(ClientLogin clientLogin) {
            return new IronforgeResp<>(ironforgeException);

        }
    }
}
