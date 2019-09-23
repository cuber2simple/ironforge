package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TCountry3166;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<TCountry3166, Long> {
}
