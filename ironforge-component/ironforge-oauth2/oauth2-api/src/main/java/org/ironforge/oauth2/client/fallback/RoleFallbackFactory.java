package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.RoleQuery;
import org.ironforge.oauth2.client.RoleFeignClient;

import java.util.List;

public class RoleFallbackFactory extends IronforgeFallbackFactory<RoleFeignClient> {
    @Override
    public RoleFeignClient createFallback(IronforgeException ironforgeException) {
        return new RoleFallback(ironforgeException);
    }

    class RoleFallback extends BaseFeignClientFallback implements RoleFeignClient {

        public RoleFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Role> add(Role role) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Role> edit(Role role) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public PageResp<Role> pageQuery(PageReq<RoleQuery> pageReq) {
            return new PageResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Role> findById(Integer id) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Boolean> resetRole(String roleCode, List<String> resources) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<List<Resource>> roles(String roleCode) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
