package org.ironforge.oauth2.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Client implements Serializable {
    private static final long serialVersionUID = 7564452180393091149L;
    private Integer id;
    private String userId;
    private String appId;
    private String appSecret;
    private String rsaPublicKey;
    private String rsaPrivateKey;
    private Integer accessTokenValidity;
    private Integer refreshTokenValidity;
    private String noticeChannelUrl;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;
}
