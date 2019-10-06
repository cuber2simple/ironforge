package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TResourceTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceTreeRepository extends JpaRepository<TResourceTree, Integer> {
}
