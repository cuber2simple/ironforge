package org.ironforge.base.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.persist.entity.TCountry3166;
import org.ironforge.base.persist.repo.CountryRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CountryService extends IronforgeService<CountryRepository, TCountry3166, Integer> {

    public TCountry3166 findByAlphaCode2(String alphaCode2) {
        return repository.findByAlphaCode2(alphaCode2);
    }

    public TCountry3166 findByAlphaCode3(String alphaCode3) {
        return repository.findByAlphaCode3(alphaCode3);
    }

    public TCountry3166 findByNumberCode(String countryNumber) {
        return repository.findByNumberCode(countryNumber);
    }
}
