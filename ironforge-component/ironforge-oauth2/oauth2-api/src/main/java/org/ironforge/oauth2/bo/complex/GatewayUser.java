package org.ironforge.oauth2.bo.complex;

import lombok.Data;
import org.ironforge.oauth2.bo.Client;
import org.ironforge.oauth2.bo.Role;
import org.ironforge.oauth2.bo.User;

import java.util.List;

@Data
public class GatewayUser {

    private User user;

    private Client client;

    private List<Role> ownRoles;
}
