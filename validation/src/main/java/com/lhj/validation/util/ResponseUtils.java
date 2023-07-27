package com.lhj.validation.util;

import ch.qos.logback.core.status.Status;
import lombok.Data;

/**
 * @author Zch
 * @data 2023/5/5
 **/
@Data
public class ResponseUtils {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 返回消息
     */
    private String message;

    /**
     * 返回数据
     */
    private Object data;

    public ResponseUtils() {
    }

    public ResponseUtils(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    /**
     * 构造一个自定义API返回
     * @param code 状态码
     * @param message 返回消息
     * @param data 返回内容
     * @return ResponseUtils
     */
    public static ResponseUtils of(Integer code, String message, Object data) {
        return new ResponseUtils(code, message, data);
    }
}
