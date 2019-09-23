package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TCardBin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardBinRepository extends JpaRepository<TCardBin, Long> {
  TCardBin findByCardBin(String cardBin);
}
