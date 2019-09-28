package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TUser, Integer> {

    TUser findByMerchantIdAndUserName(String merchantId, String userName);

    TUser findByMerchantIdAndEmail(String merchantId, String email);

    TUser findByUserId(String userId);
}
