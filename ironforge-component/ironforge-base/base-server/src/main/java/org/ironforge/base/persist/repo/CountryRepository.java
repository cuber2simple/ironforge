package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TCountry3166;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<TCountry3166, Long> {

  TCountry3166 findByAlphaCode2(String alphaCode2);

  TCountry3166 findByAlphaCode3(String alphaCode3);

  TCountry3166 findByNumberCode(String numberCode);
}
