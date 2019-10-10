package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TCountryRegion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountryRegionRepository extends JpaRepository<TCountryRegion, Integer> {
  List<TCountryRegion> findByCountryNumber(String countryNumber);
}
