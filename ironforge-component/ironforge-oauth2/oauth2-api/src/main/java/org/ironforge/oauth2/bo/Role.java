package org.ironforge.oauth2.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Role implements Serializable {
    private static final long serialVersionUID = -2171452077582739095L;
    private Integer id;
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
}
