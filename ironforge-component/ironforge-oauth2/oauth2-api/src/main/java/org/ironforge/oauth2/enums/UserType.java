package org.ironforge.oauth2.enums;

public enum UserType {
    operator("operator","操作员"),
    client("client","客户端"),
    ;
    private String code;
    private String desc;

    UserType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }
}
