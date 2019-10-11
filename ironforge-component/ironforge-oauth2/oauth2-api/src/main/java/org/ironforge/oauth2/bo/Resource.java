package org.ironforge.oauth2.bo;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class Resource implements Serializable {
    private static final long serialVersionUID = 8277302949965109249L;
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

    private List<Resource> subResource;
}
