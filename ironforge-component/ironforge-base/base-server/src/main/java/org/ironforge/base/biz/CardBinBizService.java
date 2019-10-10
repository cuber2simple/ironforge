package org.ironforge.base.biz;

import org.ironforge.base.bo.CardBin;
import org.ironforge.biz.IronforgeBizService;
import org.ironforge.bo.InvisibleCardBO;

public interface CardBinBizService extends IronforgeBizService<CardBin, Integer> {
  CardBin findByCardNo(InvisibleCardBO invisibleCardBO);
}
