package org.ironforge.base.biz;

import org.ironforge.base.bo.CardBin;
import org.ironforge.bo.InvisibleCardBO;

public interface CardBinBizService {
  CardBin findByCardNo(InvisibleCardBO invisibleCardBO);
}
