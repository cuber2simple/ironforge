package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "t_resource_tree", schema = "public", catalog = "oauth2")
public class TResourceTree implements Serializable {
    private static final long serialVersionUID = -5904423946299898030L;
    private Integer id;
    private String resourceCode;
    private String subResourceCode;
    private Integer sortIndex;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;

    public TResourceTree() {
    }

    public TResourceTree(String resourceCode, String subResourceCode) {
        this.resourceCode = resourceCode;
        this.subResourceCode = subResourceCode;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "resource_code")
    public String getResourceCode() {
        return resourceCode;
    }

    public void setResourceCode(String resourceCode) {
        this.resourceCode = resourceCode;
    }

    @Basic
    @Column(name = "sub_resource_code")
    public String getSubResourceCode() {
        return subResourceCode;
    }

    public void setSubResourceCode(String subResourceCode) {
        this.subResourceCode = subResourceCode;
    }

    @Basic
    @Column(name = "sort_index")
    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
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

        TResourceTree that = (TResourceTree) o;

        if (id != that.id) return false;
        if (resourceCode != null ? !resourceCode.equals(that.resourceCode) : that.resourceCode != null) return false;
        if (subResourceCode != null ? !subResourceCode.equals(that.subResourceCode) : that.subResourceCode != null)
            return false;
        if (sortIndex != null ? !sortIndex.equals(that.sortIndex) : that.sortIndex != null) return false;
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
        result = 31 * result + (resourceCode != null ? resourceCode.hashCode() : 0);
        result = 31 * result + (subResourceCode != null ? subResourceCode.hashCode() : 0);
        result = 31 * result + (sortIndex != null ? sortIndex.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
