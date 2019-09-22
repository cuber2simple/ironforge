package org.ironforge.base.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_country_region", schema = "public", catalog = "base")
public class TCountryRegion {
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

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "country_number")
    public String getCountryNumber() {
        return countryNumber;
    }

    public void setCountryNumber(String countryNumber) {
        this.countryNumber = countryNumber;
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
    @Column(name = "official_name_cn")
    public String getOfficialNameCn() {
        return officialNameCn;
    }

    public void setOfficialNameCn(String officialNameCn) {
        this.officialNameCn = officialNameCn;
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
    @Column(name = "region_code")
    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    @Basic
    @Column(name = "is_country")
    public String getIsCountry() {
        return isCountry;
    }

    public void setIsCountry(String isCountry) {
        this.isCountry = isCountry;
    }

    @Basic
    @Column(name = "is_sys")
    public String getIsSys() {
        return isSys;
    }

    public void setIsSys(String isSys) {
        this.isSys = isSys;
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

        TCountryRegion that = (TCountryRegion) o;

        if (id != that.id) return false;
        if (countryNumber != null ? !countryNumber.equals(that.countryNumber) : that.countryNumber != null)
            return false;
        if (officialNameEn != null ? !officialNameEn.equals(that.officialNameEn) : that.officialNameEn != null)
            return false;
        if (officialNameCn != null ? !officialNameCn.equals(that.officialNameCn) : that.officialNameCn != null)
            return false;
        if (localeName != null ? !localeName.equals(that.localeName) : that.localeName != null) return false;
        if (regionCode != null ? !regionCode.equals(that.regionCode) : that.regionCode != null) return false;
        if (isCountry != null ? !isCountry.equals(that.isCountry) : that.isCountry != null) return false;
        if (isSys != null ? !isSys.equals(that.isSys) : that.isSys != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(that.updateUserId) : that.updateUserId != null) return false;
        if (createUserId != null ? !createUserId.equals(that.createUserId) : that.createUserId != null) return false;
        if (updateDatetime != null ? !updateDatetime.equals(that.updateDatetime) : that.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(that.createDatetime) : that.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (countryNumber != null ? countryNumber.hashCode() : 0);
        result = 31 * result + (officialNameEn != null ? officialNameEn.hashCode() : 0);
        result = 31 * result + (officialNameCn != null ? officialNameCn.hashCode() : 0);
        result = 31 * result + (localeName != null ? localeName.hashCode() : 0);
        result = 31 * result + (regionCode != null ? regionCode.hashCode() : 0);
        result = 31 * result + (isCountry != null ? isCountry.hashCode() : 0);
        result = 31 * result + (isSys != null ? isSys.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
