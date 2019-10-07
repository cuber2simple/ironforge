package org.ironforge.oauth2.valid;

import org.apache.commons.lang3.StringUtils;
import org.ironforge.oauth2.bo.Login;
import org.ironforge.valid.ValidExec;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import java.util.Objects;

@Component
public class LoginValid implements ValidExec<Login> {
    @Override
    public void valid(Login login) {
        Assert.isTrue(Objects.nonNull(login),"对象不能为空");
        Assert.isTrue(StringUtils.isNotEmpty(login.getMerchantId()),"商户ID不能为空");
        Assert.isTrue(StringUtils.isNotEmpty(login.getEmail()) || StringUtils.isNotEmpty(login.getUsername()) ,"邮箱或者用户名不能为空");
        Assert.isTrue(StringUtils.isNotEmpty(login.getPassword()),"密码不能为空");
    }
}
