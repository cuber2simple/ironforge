package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.client.user.UserCurdFeignClient;

public class UserCurdFallbackFactory extends IronforgeFallbackFactory<UserCurdFeignClient> {
    @Override
    public UserCurdFeignClient createFallback(IronforgeException ironforgeException) {
        return new UserCurdFallback(ironforgeException);
    }


    class UserCurdFallback extends BaseFeignClientFallback implements UserCurdFeignClient {

        public UserCurdFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<User> insertUser(User user) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<User> findByUserId(String userId) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
