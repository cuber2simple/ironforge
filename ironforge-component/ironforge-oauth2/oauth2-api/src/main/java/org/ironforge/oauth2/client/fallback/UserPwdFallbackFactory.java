package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.ChangePwd;
import org.ironforge.oauth2.client.user.UserPwdFeignClient;

public class UserPwdFallbackFactory extends IronforgeFallbackFactory<UserPwdFeignClient> {
    @Override
    public UserPwdFeignClient createFallback(IronforgeException ironforgeException) {
        return new UserPwdFallback(ironforgeException);
    }

    class UserPwdFallback extends BaseFeignClientFallback implements UserPwdFeignClient {

        public UserPwdFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Boolean> change(ChangePwd changePwd) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Boolean> resetPwd(String userId) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
