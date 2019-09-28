package org.ironforge.oauth2.persist.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "t_user", schema = "public", catalog = "oauth2")
public class TUser {
    private int id;
    private String merchantId;
    private String userId;
    private String userType;
    private String userName;
    private String password;
    private String nickName;
    private String email;
    private String phone;
    private String employeeNo;
    private String avatar;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;

    @OneToMany
    @JoinTable(name="t_user_rule", schema = "public", catalog = "oauth2",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name="role_code", referencedColumnName = "role_code"))
    private List<TRole> roleList;

    @OneToOne
    @JoinColumn(
            name="user_id",
            referencedColumnName = "user_id"
    )
    private TUserClient tUserClient;

    public List<TRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<TRole> roleList) {
        this.roleList = roleList;
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
    @Column(name = "merchant_id")
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
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
    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "nick_name")
    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "employee_no")
    public String getEmployeeNo() {
        return employeeNo;
    }

    public void setEmployeeNo(String employeeNo) {
        this.employeeNo = employeeNo;
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

        TUser tUser = (TUser) o;

        if (id != tUser.id) return false;
        if (merchantId != null ? !merchantId.equals(tUser.merchantId) : tUser.merchantId != null) return false;
        if (userId != null ? !userId.equals(tUser.userId) : tUser.userId != null) return false;
        if (userType != null ? !userType.equals(tUser.userType) : tUser.userType != null) return false;
        if (userName != null ? !userName.equals(tUser.userName) : tUser.userName != null) return false;
        if (password != null ? !password.equals(tUser.password) : tUser.password != null) return false;
        if (nickName != null ? !nickName.equals(tUser.nickName) : tUser.nickName != null) return false;
        if (email != null ? !email.equals(tUser.email) : tUser.email != null) return false;
        if (phone != null ? !phone.equals(tUser.phone) : tUser.phone != null) return false;
        if (employeeNo != null ? !employeeNo.equals(tUser.employeeNo) : tUser.employeeNo != null) return false;
        if (avatar != null ? !avatar.equals(tUser.avatar) : tUser.avatar != null) return false;
        if (status != null ? !status.equals(tUser.status) : tUser.status != null) return false;
        if (updateUserId != null ? !updateUserId.equals(tUser.updateUserId) : tUser.updateUserId != null) return false;
        if (createUserId != null ? !createUserId.equals(tUser.createUserId) : tUser.createUserId != null) return false;
        if (updateDatetime != null ? !updateDatetime.equals(tUser.updateDatetime) : tUser.updateDatetime != null)
            return false;
        if (createDatetime != null ? !createDatetime.equals(tUser.createDatetime) : tUser.createDatetime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (merchantId != null ? merchantId.hashCode() : 0);
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (userType != null ? userType.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (employeeNo != null ? employeeNo.hashCode() : 0);
        result = 31 * result + (avatar != null ? avatar.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (updateUserId != null ? updateUserId.hashCode() : 0);
        result = 31 * result + (createUserId != null ? createUserId.hashCode() : 0);
        result = 31 * result + (updateDatetime != null ? updateDatetime.hashCode() : 0);
        result = 31 * result + (createDatetime != null ? createDatetime.hashCode() : 0);
        return result;
    }
}
