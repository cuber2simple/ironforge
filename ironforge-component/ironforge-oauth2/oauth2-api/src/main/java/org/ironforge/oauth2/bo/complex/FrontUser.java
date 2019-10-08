package org.ironforge.oauth2.bo.complex;

import lombok.Data;
import org.ironforge.oauth2.bo.Resource;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;

import java.util.List;

@Data
/**
 *  登陆之后得到用户拥有的菜单
 */
public class FrontUser {

    private User user;

    private List<Role> ownRoles;
    /**
     *  拥有的菜单
     */
    private List<Resource> ownMenus;
}
