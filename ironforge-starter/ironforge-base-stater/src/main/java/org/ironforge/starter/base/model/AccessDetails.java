package org.ironforge.starter.base.model;

import lombok.Data;

@Data
public class AccessDetails {

    /**
     * 请求ID
     */
    private String reqId;

    /**
     * 用户Id[99999999,99999999]
     * 后面99999999  代表api访问
     * 前面代表商户号， 后面代表用户号
     */
    private long userId;
    /**
     * 商户ID[99999999] 代表系统本身操作
     */
    private long merchantId;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 商户名称
     */
    private String merchantName;

    /**
     * 使用的token
     */
    private String token;
}
