package com.sinvon.server.enums;

import lombok.Getter;

/**
 * @Author: sinvon
 * @Date: 2024/05/30/下午7:39
 * @Description:
 */
@Getter
public enum LoginState {

    FAILURE(0, "登录失败"),
    SUCCESS(1, "登录成功");

    private final int code;
    private final String message;

    LoginState(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
