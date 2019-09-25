package org.ironforge.bo;

import cn.hutool.core.util.ReflectUtil;
import lombok.Data;
import org.ironforge.constants.IronforgeCode;

import java.util.Objects;

@Data
public class IronforgeResp<T extends IronforgeResp> {

    private String code;

    private String msg;

    public static boolean isSuccess(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.SUCCESS.getCode().equals(ironforgeResp.code);
        }
        return result;
    }

    public static boolean isProcess(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.PROCESS.getCode().equals(ironforgeResp.code);
        }
        return result;
    }

    public static boolean shouldRetry(IronforgeResp ironforgeResp) {
        boolean result = false;
        if (Objects.nonNull(ironforgeResp)) {
            result = IronforgeCode.RETRY.getCode().equals(ironforgeResp.code);
        }
        return result;
    }

    public static <T extends IronforgeResp> T success(T t) {
        return status(IronforgeCode.SUCCESS, t);
    }

    public static <T extends IronforgeResp> T process(T t) {
        return status(IronforgeCode.PROCESS, t);
    }

    public static <T extends IronforgeResp> T status(IronforgeCode ironforgeCode, T target) {
        if (Objects.nonNull(target)) {
            target.setCode(ironforgeCode.getCode());
            target.setMsg(ironforgeCode.getMsg());
        }
        return target;
    }

    public static <T extends IronforgeResp> T status(IronforgeCode ironforgeCode, Class<T> tClass) {
        final T target = ReflectUtil.newInstance(tClass);
        target.setCode(ironforgeCode.getCode());
        target.setMsg(ironforgeCode.getMsg());
        return target;
    }

}
