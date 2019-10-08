package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TClientToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTokenRepository extends JpaRepository<TClientToken, String> {

    TClientToken findByAppId(String appId);

}
