package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<TRole, Integer> {
    TRole findByRoleCode(String roleCode);
}
