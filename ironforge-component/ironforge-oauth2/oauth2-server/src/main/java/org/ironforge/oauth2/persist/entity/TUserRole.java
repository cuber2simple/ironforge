package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_user_role", schema = "public", catalog = "oauth2")
public class TUserRole {
    private int id;
    private String userId;
    private String roleCode;
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
    @Column(name = "user_id")
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "role_code")
    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
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

        TUserRole tUserRole = (TUserRole) o;

        if (id != tUserRole.id) return false;
        if (userId != null ? !userId.equals(tUserRole.userId) : tUserRole.userId != null) return false;
        if (roleCode != null ? !roleCode.equals(tUserRole.roleCode) : tUserRole.roleCode != null) return false;
        if (status != null ? !status.equals(tUserRole.status) : tUserRole.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tUserRole.updateUserId) : tUserRole.updateUserId != null)
            return false;
        if (createUserId != null ? !createUserId.equals(tUserRole.createUserId) : tUserRole.createUserId != null)
            return false;
        if (expireDatetime != null ? !expireDatetime.equals(tUserRole.expireDatetime) : tUserRole.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(tUserRole.updateDatetime) : tUserRole.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tUserRole.createDatetime) : tUserRole.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
