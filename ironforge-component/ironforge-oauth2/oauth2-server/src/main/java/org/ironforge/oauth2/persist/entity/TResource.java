package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_resource", schema = "public", catalog = "oauth2")
public class TResource {
    private Integer id;
    private String resourceCode;
    private String resourceName;
    private String resourceDesc;
    private String namespace;
    private String resourceType;
    private String parentCode;
    private String roadMap;
    private String url;
    private String avatar;
    private String icon;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;
    private int sortIndex;
    private List<TRole> roleList;

    @OneToMany(targetEntity = TRole.class)
    @JoinTable(name = "t_resource_role", schema = "public", catalog = "oauth2",
            joinColumns = @JoinColumn(name = "resource_code", referencedColumnName = "resource_code", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "role_code", referencedColumnName = "role_code", insertable = false, updatable = false))
    public List<TRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TRole> roleList) {
        this.roleList = roleList;
    }

    @Basic
    @Column(name = "sort_index")
    public int getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(int sortIndex) {
        this.sortIndex = sortIndex;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    @Column(name = "resource_name")
    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    @Basic
    @Column(name = "resource_desc")
    public String getResourceDesc() {
        return resourceDesc;
    }

    public void setResourceDesc(String resourceDesc) {
        this.resourceDesc = resourceDesc;
    }

    @Basic
    @Column(name = "namespace")
    public String getNamespace() {
        return namespace;
    }

    public void setNamespace(String namespace) {
        this.namespace = namespace;
    }

    @Basic
    @Column(name = "resource_type")
    public String getResourceType() {
        return resourceType;
    }

    public void setResourceType(String resourceType) {
        this.resourceType = resourceType;
    }

    @Basic
    @Column(name = "parent_code")
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "road_map")
    public String getRoadMap() {
        return roadMap;
    }

    public void setRoadMap(String roadMap) {
        this.roadMap = roadMap;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Basic
    @Column(name = "avatar")
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "icon")
    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

        TResource tResource = (TResource) o;

        if (id != tResource.id) return false;
        if (resourceCode != null ? !resourceCode.equals(tResource.resourceCode) : tResource.resourceCode != null)
            return false;
        if (resourceName != null ? !resourceName.equals(tResource.resourceName) : tResource.resourceName != null)
            return false;
        if (resourceDesc != null ? !resourceDesc.equals(tResource.resourceDesc) : tResource.resourceDesc != null)
            return false;
        if (namespace != null ? !namespace.equals(tResource.namespace) : tResource.namespace != null) return false;
        if (resourceType != null ? !resourceType.equals(tResource.resourceType) : tResource.resourceType != null)
            return false;
        if (parentCode != null ? !parentCode.equals(tResource.parentCode) : tResource.parentCode != null) return false;
        if (roadMap != null ? !roadMap.equals(tResource.roadMap) : tResource.roadMap != null) return false;
        if (url != null ? !url.equals(tResource.url) : tResource.url != null) return false;
        if (avatar != null ? !avatar.equals(tResource.avatar) : tResource.avatar != null) return false;
        if (icon != null ? !icon.equals(tResource.icon) : tResource.icon != null) return false;
        if (status != null ? !status.equals(tResource.status) : tResource.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tResource.updateUserId) : tResource.updateUserId != null)
            return false;
        if (createUserId != null ? !createUserId.equals(tResource.createUserId) : tResource.createUserId != null)
            return false;
        if (expireDatetime != null ? !expireDatetime.equals(tResource.expireDatetime) : tResource.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(tResource.updateDatetime) : tResource.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tResource.createDatetime) : tResource.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (resourceCode != null ? resourceCode.hashCode() : 0);
        result = 31 * result + (resourceName != null ? resourceName.hashCode() : 0);
        result = 31 * result + (resourceDesc != null ? resourceDesc.hashCode() : 0);
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        result = 31 * result + (resourceType != null ? resourceType.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (roadMap != null ? roadMap.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (icon != null ? icon.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
