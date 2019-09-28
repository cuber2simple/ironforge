package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupRepository extends JpaRepository<TGroup, Integer> {
    TGroup findByGroupCode(String groupCode);
}
