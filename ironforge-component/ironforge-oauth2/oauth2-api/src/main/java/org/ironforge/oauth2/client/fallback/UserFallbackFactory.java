package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;
import org.ironforge.oauth2.bo.UserQuery;
import org.ironforge.oauth2.bo.complex.FrontUser;
import org.ironforge.oauth2.client.user.UserFeignClient;

import java.util.List;

public class UserFallbackFactory extends IronforgeFallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient createFallback(IronforgeException ironforgeException) {
        return new UserFallback(ironforgeException);
    }


    class UserFallback extends BaseFeignClientFallback implements UserFeignClient {

        public UserFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<User> add(User user) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<User> findByUserId(String userId) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public PageResp<User> pageQuery(PageReq<UserQuery> pageReq) {
            return new PageResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<FrontUser> fetch() {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Boolean> resetRole(String userId, List<String> roles) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<List<Role>> roles(String userId) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
