package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TClientTokenHis;
import org.ironforge.oauth2.persist.repo.ClientTokenHisRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class ClientTokenHisService extends IronforgeService<ClientTokenHisRepository, TClientTokenHis, Integer> {
}
