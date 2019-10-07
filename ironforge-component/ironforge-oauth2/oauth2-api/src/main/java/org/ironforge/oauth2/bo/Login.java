package org.ironforge.oauth2.bo;

import lombok.Data;
import org.ironforge.oauth2.valid.LoginValid;
import org.ironforge.valid.anno.Valid;

@Data
@Valid(exec = LoginValid.class)
public class Login {

    private String merchantId;

    private String email;

    private String username;

    private String password;
}
