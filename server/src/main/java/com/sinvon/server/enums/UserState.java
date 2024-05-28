package com.sinvon.server.enums;

import lombok.Getter;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午9:17
 * @Description:
 */
@Getter
public enum UserState {


    // 用户角色
    // 管理员
    ADMIN(1, "管理员"),
    // 普通用户,
    USER(2, "普通用户"),

    // 房东
    LANDLORD(1, "房东"),
    // 租客
    TENANT(2, "租客"),


    // 账号状态
    // 账号是否已经激活
    ACTIVE(1, "激活"),
    NOT_ACTIVE(0, "未激活"),


    // 是否VIP
    VIP(1, "VIP"),
    NOT_VIP(0, "非VIP"),

    // 账号是否被封禁
    BAN(1, "封禁"),
    NOT_BAN(0, "未封禁"),

    // 账号是否被删除
    DELETE(1, "删除"),
    NOT_DELETE(0, "未删除"),

    // 账号是否被锁定
    LOCK(1, "锁定"),
    NOT_LOCK(0, "未锁定"),

    // 账号是否被注销
    CANCEL(1, "注销"),
    NOT_CANCEL(0, "未注销"),

    // 账号是否被重置
    RESET(1, "重置"),
    NOT_RESET(0, "未重置"),

    // 账号密码是否被重置
    RESET_PASSWORD(1, "重置密码"),
    NOT_RESET_PASSWORD(0, "未重置密码"),

    // 手机号是否被重置
    RESET_PHONE(1, "重置手机号"),
    NOT_RESET_PHONE(0, "未重置手机号");


    private final int code;
    private final String message;

    UserState(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
