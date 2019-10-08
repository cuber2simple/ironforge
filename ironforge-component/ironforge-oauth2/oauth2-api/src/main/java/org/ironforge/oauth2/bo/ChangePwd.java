package org.ironforge.oauth2.bo;

import lombok.Data;

@Data
public class ChangePwd {
    private String oldPwd;
    private String pwd;
}
