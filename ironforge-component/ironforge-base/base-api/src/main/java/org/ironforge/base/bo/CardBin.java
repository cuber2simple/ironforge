package org.ironforge.base.bo;

import lombok.Data;
import org.ironforge.bo.IronforgeResp;

import java.time.LocalDateTime;

@Data
public class CardBin extends IronforgeResp<CardBin> {
  private int id;
  private String cardBin;
  private String cardOrg;
  private String issuer;
  private String cardType;
  private String cardClass;
  private String issuerCountry;
  private String countryCode2;
  private String countryCode3;
  private String currencyNumber;
  private String issuerCode;
  private String cardOperator;
  private LocalDateTime operatorTime;
  private String status;
  private String cardBrand;
  private String region;
}
