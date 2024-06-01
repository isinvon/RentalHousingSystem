package com.sinvon.server.entity;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: sinvon
 * @Date: 2024/05/30/下午3:47
 * @Description: 登录日志实体类
 */

@Data
@TableName("login_log")
public class LoginLog implements Serializable {
    // 序列化的唯一标识
    // 虽然大多数情况下Java会自动处理序列化，但有时为了避免版本控制问题或优化序列化过程，你可能需要声明一个serialVersionUID字段。这个字段是一个长期不变的标识符，用于检查序列化和反序列化时类版本的一致性。
    private static final long serialVersionUID = 1L;

    /**
     * 登录日志表id
     */
    @TableId(value = "login_log_id", type = IdType.ASSIGN_ID)
    private Long loginLogId;

    /**
     * 关联用户id
     */
    private Long userId;

    /**
     * 会话id
     */
    private String sessionId;

    /**
     * 注销的时间
     */
    private Long logoutTime;

    /**
     * IP地址
     */
    private String ip;

    /**
     * 浏览器信息
     */
    private String browserInfo;

    /**
     * 登录状态
     * 0：成功，1：失败
     */
    private Integer loginStatus;

    /**
     * 创建时间
     */
    // 时间格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 字段自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


}
