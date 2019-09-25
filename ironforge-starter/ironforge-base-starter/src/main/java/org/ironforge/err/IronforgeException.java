package org.ironforge.err;

import org.ironforge.constants.IronforgeCode;

public class IronforgeException extends RuntimeException {
    private String code;

    public IronforgeException() {
        this.code = IronforgeCode.UNKNOWN.getCode();
    }

    public IronforgeException(String message) {
        super(message);
        this.code = IronforgeCode.UNKNOWN.getCode();

    }

    public IronforgeException(String message, Throwable cause) {
        super(message, cause);
        this.code = IronforgeCode.UNKNOWN.getCode();
    }

    public IronforgeException(Throwable cause) {
        super(IronforgeCode.UNKNOWN.getMsg(), cause);
        this.code = IronforgeCode.UNKNOWN.getCode();
    }

    public IronforgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = IronforgeCode.UNKNOWN.getCode();
    }

    public IronforgeException(IronforgeCode ironforgeCode, Throwable cause) {
        super(ironforgeCode.getMsg(), cause);
        this.code = ironforgeCode.getCode();
    }

    public IronforgeException(IronforgeCode ironforgeCode) {
        super(ironforgeCode.getMsg());
        this.code = ironforgeCode.getCode();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public IronforgeCode retrieve() {
        return IronforgeCode.findByCode(code);
    }

}
