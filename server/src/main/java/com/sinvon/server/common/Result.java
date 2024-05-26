package com.sinvon.server.common;

import com.sinvon.server.entity.User;
import com.sinvon.server.enums.NetworkStateCode;
import lombok.Data;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author: sinvon
 * @Date: 2024/05/24/下午11:32
 * @Description: 封装返回结果
 */
@Data
public class Result<T> {
    // 状态码
    private Integer code;
    // 信息
    private String message;
    // 描述
    private String Description;
    // 数据
    private Object data;

    @Resource
    private NetworkStateCode networkStateCode;


    /**
     * 成功返回
     *
     * @param code
     * @param message
     * @param Description
     * @param data
     * @return
     */
    public static Result success(Integer code, String message, String Description, Object data) {
        return resultData(code, message, Description, data);
    }

    public static Result success(Integer code, String message, String Description) {
        return resultData(code, message, Description, null);
    }

    public static Result success(Integer code, String message) {
        return resultData(code, message, null, null);
    }


    /**
     * 失败返回
     *
     * @param code
     * @param message
     * @param Description
     * @param data
     * @return
     */
    public static Result fail(Integer code, String message, String Description, Object data) {
        return resultData(code, message, Description, data);
    }

    public static Result fail(Integer code, String message, String Description) {
        return resultData(code, message, Description, null);
    }

    public static Result fail(Integer code, String message) {
        return resultData(code, message, null, null);
    }


    /**
     * 封装返回结果
     *
     * @param code
     * @param message
     * @param Description
     * @param data
     * @return
     */
    private static Result resultData(Integer code, String message, String Description, Object data) {
        Result result = new Result();
        result.code = code;
        result.message = message;
        result.Description = Description;
        result.data = data;
        return result;
    }


}