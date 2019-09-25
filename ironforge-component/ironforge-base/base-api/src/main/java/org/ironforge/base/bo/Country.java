package org.ironforge.base.bo;

import lombok.Data;
import org.ironforge.bo.IronforgeResp;

import java.time.LocalDateTime;

@Data
public class Country  {
  private int id;
  private String fifa;
  private String dial;
  private String alphaCode3;
  private String marc;
  private String isIndependent;
  private String numberCode;
  private String gaul;
  private String fips;
  private String wmo;
  private String alphaCode2;
  private String itu;
  private String ioc;
  private String ds;
  private String globalCode;
  private String intermediateRegionCode;
  private String developType;
  private String universalCurrency;
  private String sids;
  private String m49;
  private String subRegionCode;
  private String regionCode;
  private String lldc;
  private String intermediateRegionName;
  private String officialNameCn;
  private String officialNameEn;
  private String iso3166Name;
  private String localeName;
  private String lastedDevelopedCountries;
  private String regionName;
  private String subRegionName;
  private String globalName;
  private String capital;
  private String continent;
  private String tld;
  private String languages;
  private String geonameId;
  private String cldrDisplayName;
  private String edgar;
  private String status;
  private String updateUserId;
  private String createUserId;
  private LocalDateTime expireDatetime;
  private LocalDateTime updateDatetime;
  private LocalDateTime createDatetime;
}
