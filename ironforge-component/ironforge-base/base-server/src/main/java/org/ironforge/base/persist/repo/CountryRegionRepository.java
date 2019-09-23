package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TCountryRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRegionRepository extends JpaRepository<TCountryRegion, Long> {
}
