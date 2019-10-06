package org.ironforge.utils;

import cn.hutool.core.util.ReflectUtil;
import lombok.extern.slf4j.Slf4j;
import org.ironforge.bo.AccessDetails;

import java.lang.reflect.Field;
import java.time.LocalDateTime;
import java.util.Objects;

@Slf4j
public class ReflectUtils {

    public static final String CREATE_USER_ID = "createUserId";

    public static final String UPDATE_USER_ID = "updateUserId";

    public static final String CREATE_USER_NAME = "createUserName";

    public static final String UPDATE_USER_NAME = "updateUserName";

    public static final String CREATE_DATETIME = "createDatetime";

    public static final String UPDATE_DATETIME = "createDatetime";

    public static final String USER_ID = "userId";

    public static final String MERCHANT_ID = "merchantId";

    public static final String USER_NAME = "userName";

    public static final String MERCHANT_NAME = "merchantName";

    public static final String CUSTOMER_ID = "customerId";

    public static final String REQ_IP = "reqIp";

    public static final String REQ_ID = "reqId";

    public static final String TRACE_ID = "traceId";

    public static <T> void fillCreateInfo(T t) {
        if (Objects.nonNull(t)) {
            LocalDateTime now = LocalDateTime.now();
            AccessDetails details = SpringUtils.getCurrent();
            if (Objects.nonNull(details)) {
                emptyThenSet(t, CREATE_USER_ID, String.class, details.getUserId());
                emptyThenSet(t, UPDATE_USER_ID, String.class, details.getUserId());
                emptyThenSet(t, CREATE_USER_NAME, String.class, details.getUserName());
                emptyThenSet(t, UPDATE_USER_NAME, String.class, details.getUserName());
                emptyThenSet(t, CREATE_DATETIME, LocalDateTime.class, now);
                emptyThenSet(t, UPDATE_DATETIME, LocalDateTime.class, now);
                emptyThenSet(t, USER_ID, String.class, details.getUserId());
                emptyThenSet(t, MERCHANT_ID, String.class, details.getMerchantId());
                emptyThenSet(t, USER_NAME, String.class, details.getUserName());
                emptyThenSet(t, MERCHANT_NAME, String.class, details.getMerchantName());
                emptyThenSet(t, CUSTOMER_ID, String.class, details.getCustomerId());
                emptyThenSet(t, REQ_IP, String.class, details.getReqIp());
                emptyThenSet(t, REQ_ID, String.class, details.getReqId());
                emptyThenSet(t, TRACE_ID, String.class, details.getTraceId());
            }
        }
    }

    public static <T> void fillUpdateInfo(T t) {
        LocalDateTime now = LocalDateTime.now();
        AccessDetails details = SpringUtils.getCurrent();
        if (Objects.nonNull(details)) {
            setAnyway(t, UPDATE_USER_ID, String.class, details.getUserId());
            setAnyway(t, UPDATE_USER_NAME, String.class, details.getUserName());
            setAnyway(t, UPDATE_DATETIME, LocalDateTime.class, now);
        }

    }

    public static <T, F> void emptyThenSet(T t, String fieldName, Class<F> fClass, F fieldValue) {
        Class<?> tClass = t.getClass();
        if (ReflectUtil.hasField(tClass, fieldName)) {
            Field field = ReflectUtil.getField(tClass, fieldName);
            if (Objects.nonNull(field) && fClass.equals(field.getType())) {
                Object originValue = ReflectUtil.getFieldValue(t, field);
                if (Objects.isNull(originValue)) {
                    ReflectUtil.setFieldValue(t, field, fieldValue);
                }
            }
        }
    }

    public static <T, F> void setAnyway(T t, String fieldName, Class<F> fClass, F fieldValue) {
        Class<?> tClass = t.getClass();
        if (ReflectUtil.hasField(tClass, fieldName)) {
            Field field = ReflectUtil.getField(tClass, fieldName);
            if (Objects.nonNull(field) && fClass.equals(field.getType())) {
                ReflectUtil.setFieldValue(t, field, fieldValue);
            }
        }
    }
}
