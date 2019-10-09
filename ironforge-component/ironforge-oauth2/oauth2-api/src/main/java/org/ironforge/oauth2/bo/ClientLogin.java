package org.ironforge.oauth2.bo;

import lombok.Data;

@Data
public class ClientLogin {
    private String appId;

    private String appSecret;
}
