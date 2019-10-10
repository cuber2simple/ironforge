package org.ironforge.base.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ironforge.base.persist.entity.TCardBin;
import org.ironforge.base.persist.repo.CardBinRepository;
import org.ironforge.service.IronforgeService;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@Slf4j
public class CardBinService extends IronforgeService<CardBinRepository, TCardBin, Integer> {

    public TCardBin findMatchCardBin(String eightPrefixCardNo) {
        TCardBin eightCardBin = repository.findByCardBin(eightPrefixCardNo);
        if (Objects.isNull(eightCardBin)) {
            eightCardBin =
                    repository.findByCardBin(StringUtils.substring(eightPrefixCardNo, 0, 6));
        }
        return eightCardBin;
    }
}
