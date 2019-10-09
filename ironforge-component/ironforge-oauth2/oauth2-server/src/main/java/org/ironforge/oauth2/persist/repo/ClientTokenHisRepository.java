package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TClientTokenHis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTokenHisRepository extends JpaRepository<TClientTokenHis, String> {

}
