package com.sinvon.server.enums;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sinvon
 * @Date: 2024/05/24/下午11:57
 * @Description: 网络状态码
 */
@Getter
public enum NetworkStateCode {
    SUCCESS(200, "success", "成功"),
    FAIL(500, "fail", "失败"),
    ERROR(400, "error", "错误"),
    UNAUTHORIZED(401, "unauthorized", "未授权"),
    FORBIDDEN(403, "forbidden", "禁止访问"),
    NOT_FOUND(404, "not found", "未找到"),
    METHOD_NOT_ALLOWED(405, "method not allowed", "方法不允许"),
    NOT_ACCEPTABLE(406, "not acceptable", "不可接受"),
    REQUEST_TIMEOUT(408, "request timeout", "请求超时"),
    REQUEST_ENTITY_TOO_LARGE(413, "request entity too large", "请求实体过大"),
    REQUEST_URI_TOO_LONG(414, "request uri too long", "请求URI过长"),
    UNSUPPORTED_MEDIA_TYPE(415, "unsupported media type", "不支持的媒体类型"),
    UNPROCESSABLE_ENTITY(422, "unprocessable entity", "不可处理的实体"),
    TOO_MANY_REQUESTS(429, "too many requests", "请求过多"),
    INTERNAL_SERVER_ERROR(500, "internal server error", "内部服务器错误"),
    NOT_IMPLEMENTED(501, "not implemented", "尚未实施"),
    BAD_GATEWAY(502, "bad gateway", "错误网关"),
    SERVICE_UNAVAILABLE(503, "service unavailable", "服务不可用"),
    GATEWAY_TIMEOUT(504, "gateway timeout", "网关超时"),
    HTTP_VERSION_NOT_SUPPORTED(505, "http version not supported", "HTTP版本不受支持"),
    VARIANT_ALSO_NEGOTIATES(506, "variant also negotiates", "变体也协商"),
    INSUFFICIENT_STORAGE(507, "insufficient storage", "存储空间不足"),
    LOOP_DETECTED(508, "loop detected", "循环检测"),
    BANDWIDTH_LIMIT_EXCEEDED(509, "bandwidth limit exceeded", "带宽超出限制"),
    NOT_EXTENDED(510, "not extended", "未扩展"),
    NETWORK_AUTHENTICATION_REQUIRED(511, "network authentication required", "网络身份验证"),
    NETWORK_CONNECT_TIMEOUT_ERROR(599, "network connect timeout error", "网络连接超时"),
    UNKNOWN(999, "unknown", "未知");

    private final int code;
    private final String message;
    private final String description;


    // 构造函数
    NetworkStateCode(int code, String message, String description) {
        this.code = code;
        this.message = message;
        this.description = description;
    }


}
