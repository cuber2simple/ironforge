package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TResourceRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResourceRoleRepository extends JpaRepository<TResourceRole, Integer> {

    int deleteByRoleCode(String roleCode);

}
