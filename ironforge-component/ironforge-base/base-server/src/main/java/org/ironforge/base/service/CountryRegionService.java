package org.ironforge.base.service;

import org.ironforge.base.persist.entity.TCountryRegion;

import java.util.List;

public interface CountryRegionService {

    List<TCountryRegion> findByCountryNumber(String countryNumber);
}
