package org.ironforge.base.service;

import lombok.extern.slf4j.Slf4j;
import org.ironforge.base.BaseApplication;
import org.ironforge.base.persist.entity.TCardBin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {BaseApplication.class}) // 指定启动类
@Slf4j
public class CardBinServiceTest {

  @Autowired private CardBinService cardBinService;

  @Test
  public void testQuery() {
    TCardBin matchCardBin = cardBinService.findMatchCardBin("46938031");
    log.info("查询出来的CARDBIN为:{}", matchCardBin);
    matchCardBin = cardBinService.findMatchCardBin("46938032");
    log.info("查询出来的CARDBIN为:{}", matchCardBin);
  }
}
