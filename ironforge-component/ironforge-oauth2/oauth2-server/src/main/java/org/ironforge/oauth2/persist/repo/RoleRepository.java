package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TResource;
import org.ironforge.oauth2.persist.entity.TRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<TRole, Integer> {

    TRole findByRoleCode(String roleCode);

    @Query(value = "select tr.* from t_role tr left join t_user_role tur on tr.role_code = tur.role_code where tur.user_id = :userId", nativeQuery = true)
    List<TRole> findByUserId(@Param("userId") String userId);

    @Query(nativeQuery = true, value = "select tr.* from t_role tr left join t_resource_role tur on tr.role_code = tur.role_code left join t_resource t on tur.resource_code = t.resource_code where t.url = :url")
    List<TRole> findByUrl(@Param("url") String url);

    @Query(nativeQuery = true, value = "select t.* from t_role tr left join t_resource_role tur on tr.role_code = tur.role_code left join t_resource t on tur.resource_code = t.resource_code where tr.role_code = :roleCode")
    List<TResource> resources(@Param("roleCode") String roleCode);
}
