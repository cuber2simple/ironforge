package org.ironforge.base.persist.repo;

import org.ironforge.base.persist.entity.TMccDef;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MccRepository extends JpaRepository<TMccDef, Integer> {

  TMccDef findByMccCode(String mccCode);
}
