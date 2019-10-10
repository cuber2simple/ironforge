package org.ironforge.base.biz.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.ironforge.base.biz.CardBinBizService;
import org.ironforge.base.bo.CardBin;
import org.ironforge.base.persist.entity.TCardBin;
import org.ironforge.base.service.CardBinService;
import org.ironforge.biz.BeanCopyBizService;
import org.ironforge.bo.InvisibleCardBO;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@Slf4j
public class CardBinBizServiceImpl extends BeanCopyBizService<CardBinService, TCardBin, Integer, CardBin> implements CardBinBizService {

    public CardBinBizServiceImpl() {
        super(TCardBin.class, CardBin.class);
    }

    @Override
    public CardBin findByCardNo(InvisibleCardBO invisibleCardBO) {
        log.info("接受CARBIN查询的参数为:{}", invisibleCardBO);
        CardBin result = null;
        if (Objects.nonNull(invisibleCardBO)) {
            String cardNo = invisibleCardBO.getCardNo();
            TCardBin matchCardBin = service.findMatchCardBin(StringUtils.substring(cardNo, 0, 8));
            result = this.entityTransferBO(matchCardBin);
        }
        log.info("查询出来的结果为:{}", result);
        return result;
    }
}
