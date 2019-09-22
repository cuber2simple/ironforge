package org.ironforge.base.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_mcc_def", schema = "public", catalog = "base")
public class TMccDef {
    private int id;
    private String mccCode;
    private String officialNameEn;
    private String officialNameCn;
    private String isSys;
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
    @Column(name = "mcc_code")
    public String getMccCode() {
        return mccCode;
    }

    public void setMccCode(String mccCode) {
        this.mccCode = mccCode;
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

        TMccDef tMccDef = (TMccDef) o;

        if (id != tMccDef.id) return false;
        if (mccCode != null ? !mccCode.equals(tMccDef.mccCode) : tMccDef.mccCode != null) return false;
        if (officialNameEn != null ? !officialNameEn.equals(tMccDef.officialNameEn) : tMccDef.officialNameEn != null)
            return false;
        if (officialNameCn != null ? !officialNameCn.equals(tMccDef.officialNameCn) : tMccDef.officialNameCn != null)
            return false;
        if (isSys != null ? !isSys.equals(tMccDef.isSys) : tMccDef.isSys != null) return false;
        if (status != null ? !status.equals(tMccDef.status) : tMccDef.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tMccDef.updateUserId) : tMccDef.updateUserId != null)
            return false;
        if (createUserId != null ? !createUserId.equals(tMccDef.createUserId) : tMccDef.createUserId != null)
            return false;
        if (expireDatetime != null ? !expireDatetime.equals(tMccDef.expireDatetime) : tMccDef.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(tMccDef.updateDatetime) : tMccDef.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tMccDef.createDatetime) : tMccDef.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (mccCode != null ? mccCode.hashCode() : 0);
        result = 31 * result + (officialNameEn != null ? officialNameEn.hashCode() : 0);
        result = 31 * result + (officialNameCn != null ? officialNameCn.hashCode() : 0);
        result = 31 * result + (isSys != null ? isSys.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
