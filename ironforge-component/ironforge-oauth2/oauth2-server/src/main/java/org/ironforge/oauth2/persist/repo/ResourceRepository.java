package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRepository extends JpaRepository<TResource, Integer> {
    TResource findByResourceCode(String resourceCode);
}
