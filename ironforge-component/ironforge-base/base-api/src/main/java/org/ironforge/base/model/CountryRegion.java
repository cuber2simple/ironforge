package org.ironforge.base.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CountryRegion {
  private int id;
  private String countryNumber;
  private String officialNameEn;
  private String officialNameCn;
  private String localeName;
  private String regionCode;
  private String isCountry;
  private String isSys;
  private String status;
  private String updateUserId;
  private String createUserId;
  private LocalDateTime updateDatetime;
  private LocalDateTime createDatetime;
}
