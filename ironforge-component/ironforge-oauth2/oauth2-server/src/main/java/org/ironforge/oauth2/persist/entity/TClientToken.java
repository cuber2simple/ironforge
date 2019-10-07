package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_client_token", schema = "public", catalog = "oauth2")
public class TClientToken implements Serializable {
    private static final long serialVersionUID = 8315047938944658024L;
    private String id;
    private String appId;
    private String accessToken;
    private String refreshToken;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "app_id")
    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    @Basic
    @Column(name = "access_token")
    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    @Basic
    @Column(name = "refresh_token")
    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    @Basic
    @Column(name = "access_token_validity")
    public Integer getAccessTokenValidity() {
        return accessTokenValidity;
    }

    public void setAccessTokenValidity(Integer accessTokenValidity) {
        this.accessTokenValidity = accessTokenValidity;
    }

    @Basic
    @Column(name = "refresh_token_validity")
    public Integer getRefreshTokenValidity() {
        return refreshTokenValidity;
    }

    public void setRefreshTokenValidity(Integer refreshTokenValidity) {
        this.refreshTokenValidity = refreshTokenValidity;
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

        TClientToken that = (TClientToken) o;

        if (id != that.id) return false;
        if (appId != null ? !appId.equals(that.appId) : that.appId != null) return false;
        if (accessToken != null ? !accessToken.equals(that.accessToken) : that.accessToken != null) return false;
        if (refreshToken != null ? !refreshToken.equals(that.refreshToken) : that.refreshToken != null) return false;
        if (accessTokenValidity != null ? !accessTokenValidity.equals(that.accessTokenValidity) : that.accessTokenValidity != null)
            return false;
        if (refreshTokenValidity != null ? !refreshTokenValidity.equals(that.refreshTokenValidity) : that.refreshTokenValidity != null)
            return false;
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
        result = 31 * result + (appId != null ? appId.hashCode() : 0);
        result = 31 * result + (accessToken != null ? accessToken.hashCode() : 0);
        result = 31 * result + (refreshToken != null ? refreshToken.hashCode() : 0);
        result = 31 * result + (accessTokenValidity != null ? accessTokenValidity.hashCode() : 0);
        result = 31 * result + (refreshTokenValidity != null ? refreshTokenValidity.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
