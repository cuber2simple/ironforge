package org.ironforge.constants;

import java.util.Arrays;
import java.util.Optional;

public enum IronforgeCode {
    SUCCESS("0000", "成功"),
    FAIL("0001", "失败"),
    PROCESS("0009", "进行中"),
    RETRY("0008", "请重试"),
    UNKNOWN("9999", "未知错误"),
    INVALID_ARGUMENT("0002", "非法参数")
    ;
    protected String code;
    protected String msg;

    IronforgeCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public static IronforgeCode findByCode(String code) {
        Optional<IronforgeCode> ironforgeCodeOptional = Arrays.stream(IronforgeCode.values())
                .filter(ironforgeCode -> ironforgeCode.code.equals(code))
                .findFirst();
        return ironforgeCodeOptional.orElse(IronforgeCode.UNKNOWN);
    }
}
