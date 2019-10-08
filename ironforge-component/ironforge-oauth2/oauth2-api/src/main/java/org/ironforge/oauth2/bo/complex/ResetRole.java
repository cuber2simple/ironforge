package org.ironforge.oauth2.bo.complex;

import lombok.Data;

import java.util.List;

@Data
public class ResetRole {
    private String userId;

    private List<String> setRoles;
}
