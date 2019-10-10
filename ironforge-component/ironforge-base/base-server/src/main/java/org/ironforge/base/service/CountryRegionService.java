package org.ironforge.base.service;

import org.ironforge.base.persist.entity.TCountryRegion;
import org.ironforge.base.persist.repo.CountryRegionRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CountryRegionService extends IronforgeService<CountryRegionRepository, TCountryRegion, Integer> {

    public List<TCountryRegion> findByCountryNumber(String countryNumber){
        return repository.findByCountryNumber(countryNumber);
    }
}
