package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TClientToken;
import org.ironforge.oauth2.persist.repo.ClientTokenRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class ClientTokenService extends IronforgeService<ClientTokenRepository, TClientToken, Integer> {

}
