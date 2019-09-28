package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TUserClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserClientRepository extends JpaRepository<TUserClient, Integer> {
    TUserClient findByUserId(String userId);

    TUserClient findByAppId(String appId);
}
