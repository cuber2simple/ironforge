package org.ironforge.base.persist.entity;

import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_card_bin", schema = "public", catalog = "base")
@ToString
public class TCardBin implements Serializable {
  private static final long serialVersionUID = -1400849711535777248L;
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

  @Id
  @Column(name = "id")
  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Basic
  @Column(name = "card_bin")
  public String getCardBin() {
    return cardBin;
  }

  public void setCardBin(String cardBin) {
    this.cardBin = cardBin;
  }

  @Basic
  @Column(name = "card_org")
  public String getCardOrg() {
    return cardOrg;
  }

  public void setCardOrg(String cardOrg) {
    this.cardOrg = cardOrg;
  }

  @Basic
  @Column(name = "issuer")
  public String getIssuer() {
    return issuer;
  }

  public void setIssuer(String issuer) {
    this.issuer = issuer;
  }

  @Basic
  @Column(name = "card_type")
  public String getCardType() {
    return cardType;
  }

  public void setCardType(String cardType) {
    this.cardType = cardType;
  }

  @Basic
  @Column(name = "card_class")
  public String getCardClass() {
    return cardClass;
  }

  public void setCardClass(String cardClass) {
    this.cardClass = cardClass;
  }

  @Basic
  @Column(name = "issuer_country")
  public String getIssuerCountry() {
    return issuerCountry;
  }

  public void setIssuerCountry(String issuerCountry) {
    this.issuerCountry = issuerCountry;
  }

  @Basic
  @Column(name = "country_code2")
  public String getCountryCode2() {
    return countryCode2;
  }

  public void setCountryCode2(String countryCode2) {
    this.countryCode2 = countryCode2;
  }

  @Basic
  @Column(name = "country_code3")
  public String getCountryCode3() {
    return countryCode3;
  }

  public void setCountryCode3(String countryCode3) {
    this.countryCode3 = countryCode3;
  }

  @Basic
  @Column(name = "currency_number")
  public String getCurrencyNumber() {
    return currencyNumber;
  }

  public void setCurrencyNumber(String currencyNumber) {
    this.currencyNumber = currencyNumber;
  }

  @Basic
  @Column(name = "issuer_code")
  public String getIssuerCode() {
    return issuerCode;
  }

  public void setIssuerCode(String issuerCode) {
    this.issuerCode = issuerCode;
  }

  @Basic
  @Column(name = "card_operator")
  public String getCardOperator() {
    return cardOperator;
  }

  public void setCardOperator(String cardOperator) {
    this.cardOperator = cardOperator;
  }

  @Basic
  @Column(name = "operator_time")
  public LocalDateTime getOperatorTime() {
    return operatorTime;
  }

  public void setOperatorTime(LocalDateTime operatorTime) {
    this.operatorTime = operatorTime;
  }

  @Basic
  @Column(name = "status")
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  @Basic
  @Column(name = "card_brand")
  public String getCardBrand() {
    return cardBrand;
  }

  public void setCardBrand(String cardBrand) {
    this.cardBrand = cardBrand;
  }

  @Basic
  @Column(name = "region")
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    TCardBin tCardBin = (TCardBin) o;

    if (id != tCardBin.id) return false;
    if (cardBin != null ? !cardBin.equals(tCardBin.cardBin) : tCardBin.cardBin != null)
      return false;
    if (cardOrg != null ? !cardOrg.equals(tCardBin.cardOrg) : tCardBin.cardOrg != null)
      return false;
    if (issuer != null ? !issuer.equals(tCardBin.issuer) : tCardBin.issuer != null) return false;
    if (cardType != null ? !cardType.equals(tCardBin.cardType) : tCardBin.cardType != null)
      return false;
    if (cardClass != null ? !cardClass.equals(tCardBin.cardClass) : tCardBin.cardClass != null)
      return false;
    if (issuerCountry != null
        ? !issuerCountry.equals(tCardBin.issuerCountry)
        : tCardBin.issuerCountry != null) return false;
    if (countryCode2 != null
        ? !countryCode2.equals(tCardBin.countryCode2)
        : tCardBin.countryCode2 != null) return false;
    if (countryCode3 != null
        ? !countryCode3.equals(tCardBin.countryCode3)
        : tCardBin.countryCode3 != null) return false;
    if (currencyNumber != null
        ? !currencyNumber.equals(tCardBin.currencyNumber)
        : tCardBin.currencyNumber != null) return false;
    if (issuerCode != null ? !issuerCode.equals(tCardBin.issuerCode) : tCardBin.issuerCode != null)
      return false;
    if (cardOperator != null
        ? !cardOperator.equals(tCardBin.cardOperator)
        : tCardBin.cardOperator != null) return false;
    if (operatorTime != null
        ? !operatorTime.equals(tCardBin.operatorTime)
        : tCardBin.operatorTime != null) return false;
    if (status != null ? !status.equals(tCardBin.status) : tCardBin.status != null) return false;
    if (cardBrand != null ? !cardBrand.equals(tCardBin.cardBrand) : tCardBin.cardBrand != null)
      return false;
    if (region != null ? !region.equals(tCardBin.region) : tCardBin.region != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = id;
    result = 31 * result + (cardBin != null ? cardBin.hashCode() : 0);
    result = 31 * result + (cardOrg != null ? cardOrg.hashCode() : 0);
    result = 31 * result + (issuer != null ? issuer.hashCode() : 0);
    result = 31 * result + (cardType != null ? cardType.hashCode() : 0);
    result = 31 * result + (cardClass != null ? cardClass.hashCode() : 0);
    result = 31 * result + (issuerCountry != null ? issuerCountry.hashCode() : 0);
    result = 31 * result + (countryCode2 != null ? countryCode2.hashCode() : 0);
    result = 31 * result + (countryCode3 != null ? countryCode3.hashCode() : 0);
    result = 31 * result + (currencyNumber != null ? currencyNumber.hashCode() : 0);
    result = 31 * result + (issuerCode != null ? issuerCode.hashCode() : 0);
    result = 31 * result + (cardOperator != null ? cardOperator.hashCode() : 0);
    result = 31 * result + (operatorTime != null ? operatorTime.hashCode() : 0);
    result = 31 * result + (status != null ? status.hashCode() : 0);
    result = 31 * result + (cardBrand != null ? cardBrand.hashCode() : 0);
    result = 31 * result + (region != null ? region.hashCode() : 0);
    return result;
  }
}
