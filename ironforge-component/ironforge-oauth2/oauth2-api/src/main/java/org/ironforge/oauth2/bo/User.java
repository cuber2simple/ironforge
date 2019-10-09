package org.ironforge.oauth2.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class User implements Serializable {

    private static final long serialVersionUID = 41409900135788957L;
    private Integer id;
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

}
