package org.ironforge.bo;

import lombok.Data;
import org.ironforge.constants.IronforgeCode;
import org.ironforge.err.IronforgeException;

import java.util.Objects;

@Data
public class IronforgeResp<T> {

    private String respCode;

    private String respMsg;

    private T data;

    public IronforgeResp() {
    }

    public IronforgeResp(String respCode, String respMsg, T data) {
        this.respCode = respCode;
        this.respMsg = respMsg;
        this.data = data;
    }

    public IronforgeResp(String respCode, String respMsg) {
        this(respCode, respMsg, null);
    }

    public IronforgeResp(T data) {
        this.data = data;
    }

    public IronforgeResp(IronforgeCode ironforgeCode, T data) {
        this(ironforgeCode.getCode(), ironforgeCode.getMsg(), data);
    }

    public IronforgeResp(IronforgeException ironforgeException, T data) {
        this(ironforgeException.getCode(), ironforgeException.getMessage(), data);
    }

    public IronforgeResp(IronforgeException ironforgeException) {
        this(ironforgeException.getCode(), ironforgeException.getMessage());
    }


    public static <T> IronforgeResp<T> success(T data) {
        return new IronforgeResp<>(IronforgeCode.SUCCESS, data);
    }

    public static <T> IronforgeResp<T> status(IronforgeCode ironforgeCode, T data) {
        return new IronforgeResp<>(ironforgeCode, data);
    }

    public static <T> IronforgeResp<T> process(T data) {
        return new IronforgeResp<>(IronforgeCode.PROCESS, data);
    }

    public static <T> IronforgeResp<T> status(IronforgeCode ironforgeCode) {
        return new IronforgeResp(ironforgeCode);
    }

    public static boolean isSuccess(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.SUCCESS.getCode().equals(ironforgeResp.getRespCode());
        }
        return result;
    }


    public static boolean isProcess(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.PROCESS.getCode().equals(ironforgeResp.getRespCode());
        }
        return result;
    }


    public static boolean shouldRetry(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.RETRY.getCode().equals(ironforgeResp.getRespCode());
        }
        return result;
    }


}
