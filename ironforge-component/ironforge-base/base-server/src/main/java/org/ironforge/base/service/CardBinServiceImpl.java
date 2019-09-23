package org.ironforge.base.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ironforge.base.persist.entity.TCardBin;
import org.ironforge.base.persist.repo.CardBinRepository;
import org.ironforge.base.service.CardBinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class CardBinServiceImpl implements CardBinService {

  @Autowired private CardBinRepository cardBinRepository;

  @Override
  @Cacheable(key = "'base:cardbin:'.concat(#p0)", cacheNames = "base:cardbin")
  public TCardBin findMatchCardBin(String eightPrefixCardNo) {
    log.info("query for db:{}", eightPrefixCardNo);
    TCardBin eightCardBin = cardBinRepository.findByCardBin(eightPrefixCardNo);
    if (Objects.isNull(eightCardBin)) {
      eightCardBin =
          cardBinRepository.findByCardBin(StringUtils.substring(eightPrefixCardNo, 0, 6));
    }
    return eightCardBin;
  }
}
