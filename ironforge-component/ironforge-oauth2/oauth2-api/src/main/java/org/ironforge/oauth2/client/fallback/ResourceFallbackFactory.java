package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.ResourceQuery;
import org.ironforge.oauth2.client.ResourceFeignClient;

public class ResourceFallbackFactory extends IronforgeFallbackFactory<ResourceFeignClient> {
    @Override
    public ResourceFeignClient createFallback(IronforgeException ironforgeException) {
        return new ResourceFallback(ironforgeException);
    }

    class ResourceFallback extends BaseFeignClientFallback implements ResourceFeignClient {

        public ResourceFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Resource> add(Resource resource) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Resource> edit(Resource resource) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public PageResp<Resource> pageQuery(PageReq<ResourceQuery> pageReq) {
            return new PageResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Resource> findById(Integer id) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
