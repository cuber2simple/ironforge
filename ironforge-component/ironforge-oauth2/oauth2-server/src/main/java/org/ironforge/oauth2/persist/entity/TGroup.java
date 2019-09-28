package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_group", schema = "public", catalog = "oauth2")
public class TGroup {
    private int id;
    private String groupCode;
    private String groupName;
    private String groupDesc;
    private String namespace;
    private String parentCode;
    private String managerRoleCode;
    private String avatar;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;
    private TRole managerRule;
    private List<TRole> roleList;


    @OneToMany(targetEntity = TRole.class)
    @JoinTable(name = "t_group_role", schema = "public", catalog = "oauth2",
            joinColumns = @JoinColumn(name = "group_code", referencedColumnName = "group_code", insertable = false, updatable = false),
            inverseJoinColumns = @JoinColumn(name = "role_code", referencedColumnName = "role_code", insertable = false, updatable = false))
    public List<TRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TRole> roleList) {
        this.roleList = roleList;
    }

    @ManyToOne(targetEntity = TRole.class)
    @JoinColumn(
            name = "manager_role_code",
            referencedColumnName = "role_code",
            insertable = false,
            updatable = false
    )
    public TRole getManagerRule() {
        return managerRule;
    }

    public void setManagerRule(TRole managerRule) {
        this.managerRule = managerRule;
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
    @Column(name = "group_code")
    public String getGroupCode() {
        return groupCode;
    }

    public void setGroupCode(String groupCode) {
        this.groupCode = groupCode;
    }

    @Basic
    @Column(name = "group_name")
    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    @Basic
    @Column(name = "group_desc")
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
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
    @Column(name = "parent_code")
    public String getParentCode() {
        return parentCode;
    }

    public void setParentCode(String parentCode) {
        this.parentCode = parentCode;
    }

    @Basic
    @Column(name = "manager_role_code")
    public String getManagerRoleCode() {
        return managerRoleCode;
    }

    public void setManagerRoleCode(String managerRoleCode) {
        this.managerRoleCode = managerRoleCode;
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

        TGroup tGroup = (TGroup) o;

        if (id != tGroup.id) return false;
        if (groupCode != null ? !groupCode.equals(tGroup.groupCode) : tGroup.groupCode != null) return false;
        if (groupName != null ? !groupName.equals(tGroup.groupName) : tGroup.groupName != null) return false;
        if (groupDesc != null ? !groupDesc.equals(tGroup.groupDesc) : tGroup.groupDesc != null) return false;
        if (namespace != null ? !namespace.equals(tGroup.namespace) : tGroup.namespace != null) return false;
        if (parentCode != null ? !parentCode.equals(tGroup.parentCode) : tGroup.parentCode != null) return false;
        if (managerRoleCode != null ? !managerRoleCode.equals(tGroup.managerRoleCode) : tGroup.managerRoleCode != null)
            return false;
        if (avatar != null ? !avatar.equals(tGroup.avatar) : tGroup.avatar != null) return false;
        if (status != null ? !status.equals(tGroup.status) : tGroup.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tGroup.updateUserId) : tGroup.updateUserId != null)
            return false;
        if (createUserId != null ? !createUserId.equals(tGroup.createUserId) : tGroup.createUserId != null)
            return false;
        if (expireDatetime != null ? !expireDatetime.equals(tGroup.expireDatetime) : tGroup.expireDatetime != null)
            return false;
        if (updateDatetime != null ? !updateDatetime.equals(tGroup.updateDatetime) : tGroup.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tGroup.createDatetime) : tGroup.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (groupCode != null ? groupCode.hashCode() : 0);
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (groupDesc != null ? groupDesc.hashCode() : 0);
        result = 31 * result + (namespace != null ? namespace.hashCode() : 0);
        result = 31 * result + (parentCode != null ? parentCode.hashCode() : 0);
        result = 31 * result + (managerRoleCode != null ? managerRoleCode.hashCode() : 0);
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
