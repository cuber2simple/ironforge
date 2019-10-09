package org.ironforge.oauth2.client.fallback;

import org.ironforge.bo.IronforgeResp;
import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.err.IronforgeException;
import org.ironforge.hystrix.BaseFeignClientFallback;
import org.ironforge.hystrix.IronforgeFallbackFactory;
import org.ironforge.oauth2.bo.Client;
import org.ironforge.oauth2.bo.ClientQuery;
import org.ironforge.oauth2.client.ClientFeignClient;

public class ClientFallbackFactory extends IronforgeFallbackFactory<ClientFeignClient> {
    @Override
    public ClientFeignClient createFallback(IronforgeException ironforgeException) {
        return new ClientFallback(ironforgeException);
    }

    class ClientFallback extends BaseFeignClientFallback implements ClientFeignClient {

        public ClientFallback(IronforgeException ironforgeException) {
            super(ironforgeException);
        }

        @Override
        public IronforgeResp<Client> edit(Client client) {
            return new IronforgeResp<>(ironforgeException);
        }

        @Override
        public PageResp<Client> pageQuery(PageReq<ClientQuery> pageReq) {
            return new PageResp<>(ironforgeException);
        }

        @Override
        public IronforgeResp<Client> findById(Integer id) {
            return new IronforgeResp<>(ironforgeException);
        }
    }
}
