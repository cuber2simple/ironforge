package org.ironforge.oauth2.bo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Resource {
    private Integer id;
    private String resourceCode;
    private String resourceName;
    private String resourceDesc;
    private String resourceType;
    private String namespace;
    private String url;
    private String avatar;
    private String icon;
    private String status;
    private String updateUserId;
    private String createUserId;
    private LocalDateTime expireDatetime;
    private LocalDateTime updateDatetime;
    private LocalDateTime createDatetime;
}
