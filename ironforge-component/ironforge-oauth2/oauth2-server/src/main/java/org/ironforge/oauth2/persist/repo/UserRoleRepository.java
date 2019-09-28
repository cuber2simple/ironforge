package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TUserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<TUserRole, Integer> {
}
