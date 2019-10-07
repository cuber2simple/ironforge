package org.ironforge.oauth2.enums;

public enum TokenType {
    access("access", "访问的TOKEN"),
    refresh("refresh", "刷新的token"),
    ;
    private String code;
    private String desc;

    TokenType(String code, String desc) {
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
