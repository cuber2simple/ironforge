package org.ironforge.oauth2.dto;

import lombok.Data;

@Data
public class TokenDTO {

    private String tokenId;

    private String userId;

    private String tokenType;

    private String expireDatetime;

    private String createDateTime;
}
