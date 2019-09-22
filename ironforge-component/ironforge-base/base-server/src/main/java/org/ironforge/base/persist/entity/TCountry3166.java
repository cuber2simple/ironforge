package org.ironforge.base.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_country_3166", schema = "public", catalog = "base")
public class TCountry3166 {
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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "fifa")
    public String getFifa() {
        return fifa;
    }

    public void setFifa(String fifa) {
        this.fifa = fifa;
    }

    @Basic
    @Column(name = "dial")
    public String getDial() {
        return dial;
    }

    public void setDial(String dial) {
        this.dial = dial;
    }

    @Basic
    @Column(name = "alpha_code_3")
    public String getAlphaCode3() {
        return alphaCode3;
    }

    public void setAlphaCode3(String alphaCode3) {
        this.alphaCode3 = alphaCode3;
    }

    @Basic
    @Column(name = "marc")
    public String getMarc() {
        return marc;
    }

    public void setMarc(String marc) {
        this.marc = marc;
    }

    @Basic
    @Column(name = "is_independent")
    public String getIsIndependent() {
        return isIndependent;
    }

    public void setIsIndependent(String isIndependent) {
        this.isIndependent = isIndependent;
    }

    @Basic
    @Column(name = "number_code")
    public String getNumberCode() {
        return numberCode;
    }

    public void setNumberCode(String numberCode) {
        this.numberCode = numberCode;
    }

    @Basic
    @Column(name = "gaul")
    public String getGaul() {
        return gaul;
    }

    public void setGaul(String gaul) {
        this.gaul = gaul;
    }

    @Basic
    @Column(name = "fips")
    public String getFips() {
        return fips;
    }

    public void setFips(String fips) {
        this.fips = fips;
    }

    @Basic
    @Column(name = "wmo")
    public String getWmo() {
        return wmo;
    }

    public void setWmo(String wmo) {
        this.wmo = wmo;
    }

    @Basic
    @Column(name = "alpha_code_2")
    public String getAlphaCode2() {
        return alphaCode2;
    }

    public void setAlphaCode2(String alphaCode2) {
        this.alphaCode2 = alphaCode2;
    }

    @Basic
    @Column(name = "itu")
    public String getItu() {
        return itu;
    }

    public void setItu(String itu) {
        this.itu = itu;
    }

    @Basic
    @Column(name = "ioc")
    public String getIoc() {
        return ioc;
    }

    public void setIoc(String ioc) {
        this.ioc = ioc;
    }

    @Basic
    @Column(name = "ds")
    public String getDs() {
        return ds;
    }

    public void setDs(String ds) {
        this.ds = ds;
    }

    @Basic
    @Column(name = "global_code")
    public String getGlobalCode() {
        return globalCode;
    }

    public void setGlobalCode(String globalCode) {
        this.globalCode = globalCode;
    }

    @Basic
    @Column(name = "intermediate_region_code")
    public String getIntermediateRegionCode() {
        return intermediateRegionCode;
    }

    public void setIntermediateRegionCode(String intermediateRegionCode) {
        this.intermediateRegionCode = intermediateRegionCode;
    }

    @Basic
    @Column(name = "develop_type")
    public String getDevelopType() {
        return developType;
    }

    public void setDevelopType(String developType) {
        this.developType = developType;
    }

    @Basic
    @Column(name = "universal_currency")
    public String getUniversalCurrency() {
        return universalCurrency;
    }

    public void setUniversalCurrency(String universalCurrency) {
        this.universalCurrency = universalCurrency;
    }

    @Basic
    @Column(name = "sids")
    public String getSids() {
        return sids;
    }

    public void setSids(String sids) {
        this.sids = sids;
    }

    @Basic
    @Column(name = "m49")
    public String getM49() {
        return m49;
    }

    public void setM49(String m49) {
        this.m49 = m49;
    }

    @Basic
    @Column(name = "sub_region_code")
    public String getSubRegionCode() {
        return subRegionCode;
    }

    public void setSubRegionCode(String subRegionCode) {
        this.subRegionCode = subRegionCode;
    }

    @Basic
    @Column(name = "region_code")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "lldc")
    public String getLldc() {
        return lldc;
    }

    public void setLldc(String lldc) {
        this.lldc = lldc;
    }

    @Basic
    @Column(name = "intermediate_region_name")
    public String getIntermediateRegionName() {
        return intermediateRegionName;
    }

    public void setIntermediateRegionName(String intermediateRegionName) {
        this.intermediateRegionName = intermediateRegionName;
    }

    @Basic
    @Column(name = "official_name_cn")
    public String getOfficialNameCn() {
        return officialNameCn;
    }

    public void setOfficialNameCn(String officialNameCn) {
        this.officialNameCn = officialNameCn;
    }

    @Basic
    @Column(name = "official_name_en")
    public String getOfficialNameEn() {
        return officialNameEn;
    }

    public void setOfficialNameEn(String officialNameEn) {
        this.officialNameEn = officialNameEn;
    }

    @Basic
    @Column(name = "iso_3166_name")
    public String getIso3166Name() {
        return iso3166Name;
    }

    public void setIso3166Name(String iso3166Name) {
        this.iso3166Name = iso3166Name;
    }

    @Basic
    @Column(name = "locale_name")
    public String getLocaleName() {
        return localeName;
    }

    public void setLocaleName(String localeName) {
        this.localeName = localeName;
    }

    @Basic
    @Column(name = "lasted_developed_countries")
    public String getLastedDevelopedCountries() {
        return lastedDevelopedCountries;
    }

    public void setLastedDevelopedCountries(String lastedDevelopedCountries) {
        this.lastedDevelopedCountries = lastedDevelopedCountries;
    }

    @Basic
    @Column(name = "region_name")
    public String getRegionName() {
        return regionName;
    }

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    @Basic
    @Column(name = "sub_region_name")
    public String getSubRegionName() {
        return subRegionName;
    }

    public void setSubRegionName(String subRegionName) {
        this.subRegionName = subRegionName;
    }

    @Basic
    @Column(name = "global_name")
    public String getGlobalName() {
        return globalName;
    }

    public void setGlobalName(String globalName) {
        this.globalName = globalName;
    }

    @Basic
    @Column(name = "capital")
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "continent")
    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    @Basic
    @Column(name = "tld")
    public String getTld() {
        return tld;
    }

    public void setTld(String tld) {
        this.tld = tld;
    }

    @Basic
    @Column(name = "languages")
    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    @Basic
    @Column(name = "geoname_id")
    public String getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(String geonameId) {
        this.geonameId = geonameId;
    }

    @Basic
    @Column(name = "cldr_display_name")
    public String getCldrDisplayName() {
        return cldrDisplayName;
    }

    public void setCldrDisplayName(String cldrDisplayName) {
        this.cldrDisplayName = cldrDisplayName;
    }

    @Basic
    @Column(name = "edgar")
    public String getEdgar() {
        return edgar;
    }

    public void setEdgar(String edgar) {
        this.edgar = edgar;
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
    @Column(name = "update_user_id")
    public String getUpdateUserId() {
        return updateUserId;
    }

    public void setUpdateUserId(String updateUserId) {
        this.updateUserId = updateUserId;
    }

    @Basic
    @Column(name = "create_user_id")
    public String getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(String createUserId) {
        this.createUserId = createUserId;
    }

    @Basic
    @Column(name = "expire_datetime")
    public LocalDateTime getExpireDatetime() {
        return expireDatetime;
    }

    public void setExpireDatetime(LocalDateTime expireDatetime) {
        this.expireDatetime = expireDatetime;
    }

    @Basic
    @Column(name = "update_datetime")
    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Basic
    @Column(name = "create_datetime")
    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TCountry3166 that = (TCountry3166) o;

        if (id != that.id) return false;
        if (fifa != null ? !fifa.equals(that.fifa) : that.fifa != null) return false;
        if (dial != null ? !dial.equals(that.dial) : that.dial != null) return false;
        if (alphaCode3 != null ? !alphaCode3.equals(that.alphaCode3) : that.alphaCode3 != null) return false;
        if (marc != null ? !marc.equals(that.marc) : that.marc != null) return false;
        if (isIndependent != null ? !isIndependent.equals(that.isIndependent) : that.isIndependent != null)
            return false;
        if (numberCode != null ? !numberCode.equals(that.numberCode) : that.numberCode != null) return false;
        if (gaul != null ? !gaul.equals(that.gaul) : that.gaul != null) return false;
        if (fips != null ? !fips.equals(that.fips) : that.fips != null) return false;
        if (wmo != null ? !wmo.equals(that.wmo) : that.wmo != null) return false;
        if (alphaCode2 != null ? !alphaCode2.equals(that.alphaCode2) : that.alphaCode2 != null) return false;
        if (itu != null ? !itu.equals(that.itu) : that.itu != null) return false;
        if (ioc != null ? !ioc.equals(that.ioc) : that.ioc != null) return false;
        if (ds != null ? !ds.equals(that.ds) : that.ds != null) return false;
        if (globalCode != null ? !globalCode.equals(that.globalCode) : that.globalCode != null) return false;
        if (intermediateRegionCode != null ? !intermediateRegionCode.equals(that.intermediateRegionCode) : that.intermediateRegionCode != null)
            return false;
        if (developType != null ? !developType.equals(that.developType) : that.developType != null) return false;
        if (universalCurrency != null ? !universalCurrency.equals(that.universalCurrency) : that.universalCurrency != null)
            return false;
        if (sids != null ? !sids.equals(that.sids) : that.sids != null) return false;
        if (m49 != null ? !m49.equals(that.m49) : that.m49 != null) return false;
        if (subRegionCode != null ? !subRegionCode.equals(that.subRegionCode) : that.subRegionCode != null)
            return false;
        if (regionCode != null ? !regionCode.equals(that.regionCode) : that.regionCode != null) return false;
        if (lldc != null ? !lldc.equals(that.lldc) : that.lldc != null) return false;
        if (intermediateRegionName != null ? !intermediateRegionName.equals(that.intermediateRegionName) : that.intermediateRegionName != null)
            return false;
        if (officialNameCn != null ? !officialNameCn.equals(that.officialNameCn) : that.officialNameCn != null)
            return false;
        if (officialNameEn != null ? !officialNameEn.equals(that.officialNameEn) : that.officialNameEn != null)
            return false;
        if (iso3166Name != null ? !iso3166Name.equals(that.iso3166Name) : that.iso3166Name != null) return false;
        if (localeName != null ? !localeName.equals(that.localeName) : that.localeName != null) return false;
        if (lastedDevelopedCountries != null ? !lastedDevelopedCountries.equals(that.lastedDevelopedCountries) : that.lastedDevelopedCountries != null)
            return false;
        if (regionName != null ? !regionName.equals(that.regionName) : that.regionName != null) return false;
        if (subRegionName != null ? !subRegionName.equals(that.subRegionName) : that.subRegionName != null)
            return false;
        if (globalName != null ? !globalName.equals(that.globalName) : that.globalName != null) return false;
        if (capital != null ? !capital.equals(that.capital) : that.capital != null) return false;
        if (continent != null ? !continent.equals(that.continent) : that.continent != null) return false;
        if (tld != null ? !tld.equals(that.tld) : that.tld != null) return false;
        if (languages != null ? !languages.equals(that.languages) : that.languages != null) return false;
        if (geonameId != null ? !geonameId.equals(that.geonameId) : that.geonameId != null) return false;
        if (cldrDisplayName != null ? !cldrDisplayName.equals(that.cldrDisplayName) : that.cldrDisplayName != null)
            return false;
        if (edgar != null ? !edgar.equals(that.edgar) : that.edgar != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (expireDatetime != null ? !expireDatetime.equals(that.expireDatetime) : that.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(that.updateDatetime) : that.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(that.createDatetime) : that.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (fifa != null ? fifa.hashCode() : 0);
        result = 31 * result + (dial != null ? dial.hashCode() : 0);
        result = 31 * result + (alphaCode3 != null ? alphaCode3.hashCode() : 0);
        result = 31 * result + (marc != null ? marc.hashCode() : 0);
        result = 31 * result + (isIndependent != null ? isIndependent.hashCode() : 0);
        result = 31 * result + (numberCode != null ? numberCode.hashCode() : 0);
        result = 31 * result + (gaul != null ? gaul.hashCode() : 0);
        result = 31 * result + (fips != null ? fips.hashCode() : 0);
        result = 31 * result + (wmo != null ? wmo.hashCode() : 0);
        result = 31 * result + (alphaCode2 != null ? alphaCode2.hashCode() : 0);
        result = 31 * result + (itu != null ? itu.hashCode() : 0);
        result = 31 * result + (ioc != null ? ioc.hashCode() : 0);
        result = 31 * result + (ds != null ? ds.hashCode() : 0);
        result = 31 * result + (globalCode != null ? globalCode.hashCode() : 0);
        result = 31 * result + (intermediateRegionCode != null ? intermediateRegionCode.hashCode() : 0);
        result = 31 * result + (developType != null ? developType.hashCode() : 0);
        result = 31 * result + (universalCurrency != null ? universalCurrency.hashCode() : 0);
        result = 31 * result + (sids != null ? sids.hashCode() : 0);
        result = 31 * result + (m49 != null ? m49.hashCode() : 0);
        result = 31 * result + (subRegionCode != null ? subRegionCode.hashCode() : 0);
        result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
        result = 31 * result + (lldc != null ? lldc.hashCode() : 0);
        result = 31 * result + (intermediateRegionName != null ? intermediateRegionName.hashCode() : 0);
        result = 31 * result + (officialNameCn != null ? officialNameCn.hashCode() : 0);
        result = 31 * result + (officialNameEn != null ? officialNameEn.hashCode() : 0);
        result = 31 * result + (iso3166Name != null ? iso3166Name.hashCode() : 0);
        result = 31 * result + (localeName != null ? localeName.hashCode() : 0);
        result = 31 * result + (lastedDevelopedCountries != null ? lastedDevelopedCountries.hashCode() : 0);
        result = 31 * result + (regionName != null ? regionName.hashCode() : 0);
        result = 31 * result + (subRegionName != null ? subRegionName.hashCode() : 0);
        result = 31 * result + (globalName != null ? globalName.hashCode() : 0);
        result = 31 * result + (capital != null ? capital.hashCode() : 0);
        result = 31 * result + (continent != null ? continent.hashCode() : 0);
        result = 31 * result + (tld != null ? tld.hashCode() : 0);
        result = 31 * result + (languages != null ? languages.hashCode() : 0);
        result = 31 * result + (geonameId != null ? geonameId.hashCode() : 0);
        result = 31 * result + (cldrDisplayName != null ? cldrDisplayName.hashCode() : 0);
        result = 31 * result + (edgar != null ? edgar.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
