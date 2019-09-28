package org.ironforge.oauth2.service;

import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.repo.UserRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Service;

@Service
public class UserService extends IronforgeService<UserRepository, TUser, Integer> {
    public TUser findByMerchantIdAndUserName(String merchantId, String userName) {
        return repository.findByMerchantIdAndUserName(merchantId, userName);
    }

    public TUser findByMerchantIdAndEmail(String merchantId, String email) {
        return repository.findByMerchantIdAndEmail(merchantId, email);
    }

    public TUser findByUserId(String userId) {
        return repository.findByUserId(userId);
    }
}
