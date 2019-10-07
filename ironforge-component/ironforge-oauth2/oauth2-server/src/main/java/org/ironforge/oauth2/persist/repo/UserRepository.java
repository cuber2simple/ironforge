package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<TUser, Integer> {

    TUser findByMerchantIdAndUserName(String merchantId, String userName);

    TUser findByMerchantIdAndEmail(String merchantId, String email);

    TUser findByUserId(String userId);

    @Query(value = "select to_number(substring(coalesce(user_id,'1560000000100000001') from 12 for 8),'99999999') from t_user where merchant_id = ?1 and user_type = 'operator' order by id desc limit 1", nativeQuery = true)
    Integer findBigUserIdUnderMerchantId(String merchantId);
}
