package org.ironforge.bo;

import lombok.Data;

@Data
public class Token {

    private String accessToken;

    private String refreshToken;

    /**
     * 过期时间 yyyyMMddHHmmss
     */
    private String expireDatetime;
    /**
     * 创建时间 yyyyMMddHHmmss
     */
    private String createDatetime;
}
