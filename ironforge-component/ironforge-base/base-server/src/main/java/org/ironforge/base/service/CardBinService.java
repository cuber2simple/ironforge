package org.ironforge.base.service;

import org.ironforge.base.persist.entity.TCardBin;

public interface CardBinService {

  TCardBin findMatchCardBin(String eightPrefixCardNo);
}
