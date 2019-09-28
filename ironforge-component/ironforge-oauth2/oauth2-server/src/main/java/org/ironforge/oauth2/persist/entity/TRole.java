package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_role", schema = "public", catalog = "oauth2")
public class TRole {
    private int id;
    private String roleCode;
    private String roleName;
    private String roleDesc;
    private String namespace;
    private String superManager;
    private String avatar;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;
    private List<TResource> resourceList;

    @OneToMany(targetEntity = TResource.class)
    @JoinTable(name = "t_resource_role", schema = "public", catalog = "oauth2",
            joinColumns = @JoinColumn(name = "role_code", referencedColumnName = "role_code"),
            inverseJoinColumns = @JoinColumn(name = "resource_code", referencedColumnName = "resource_code"))
    public List<TResource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<TResource> resourceList) {
        this.resourceList = resourceList;
    }

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "role_name")
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Basic
    @Column(name = "role_desc")
    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
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
    @Column(name = "super_manager")
    public String getSuperManager() {
        return superManager;
    }

    public void setSuperManager(String superManager) {
        this.superManager = superManager;
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

        TRole tRole = (TRole) o;

        if (id != tRole.id) return false;
        if (roleCode != null ? !roleCode.equals(tRole.roleCode) : tRole.roleCode != null) return false;
        if (roleName != null ? !roleName.equals(tRole.roleName) : tRole.roleName != null) return false;
        if (roleDesc != null ? !roleDesc.equals(tRole.roleDesc) : tRole.roleDesc != null) return false;
        if (namespace != null ? !namespace.equals(tRole.namespace) : tRole.namespace != null) return false;
        if (superManager != null ? !superManager.equals(tRole.superManager) : tRole.superManager != null) return false;
        if (avatar != null ? !avatar.equals(tRole.avatar) : tRole.avatar != null) return false;
        if (status != null ? !status.equals(tRole.status) : tRole.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tRole.updateUserId) : tRole.updateUserId != null) return false;
        if (createUserId != null ? !createUserId.equals(tRole.createUserId) : tRole.createUserId != null) return false;
        if (expireDatetime != null ? !expireDatetime.equals(tRole.expireDatetime) : tRole.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(tRole.updateDatetime) : tRole.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tRole.createDatetime) : tRole.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (roleCode != null ? roleCode.hashCode() : 0);
        result = 31 * result + (roleName != null ? roleName.hashCode() : 0);
        result = 31 * result + (roleDesc != null ? roleDesc.hashCode() : 0);
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        result = 31 * result + (superManager != null ? superManager.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (expireDatetime != null ? expireDatetime.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
