package org.ironforge.oauth2.persist.repo;

import org.ironforge.oauth2.persist.entity.TResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResourceRepository extends JpaRepository<TResource, Integer> {

    TResource findByResourceCode(String resourceCode);

    @Query(nativeQuery = true, value = "select tr.* from t_resource tr left join t_resource_tree tur on tr.resource_code = tur.sub_resource_code where tur.resource_code = :resourceCode")
    List<TResource> findSubElements(@Param("resourceCode") String resourceCode);
}
