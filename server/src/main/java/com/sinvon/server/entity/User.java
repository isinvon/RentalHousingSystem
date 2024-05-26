package com.sinvon.server.entity;


import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@TableName("user")
public class User {

    /**
     * 主键 user_id
     * type = IdType.ASSIGN_ID 设置id自动生成类型为雪花算法
     */
    @TableId(value = "user_id", type = IdType.ASSIGN_ID) // 主键自增雪花id
    private Long userId;

    /**
     * 用户名
     */
    private String username;

    /**
     * 姓名(全名)
     */
    private String fullname;

    /**
     * 密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 角色
     * 1：房东(普通用户)
     * 2：租客(普通用户)
     * 3：管理员
     */
    private Integer role;

    /**
     * 积分
     */
    private Integer score;

    /**
     * 激活状态
     * 0：未激活
     * 1：已激活
     */
    private Integer isActive;

    /**
     * 创建时间
     */
    // 时间格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 字段自动填充
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;


    /**
     * 更新时间
     */
    // 时间格式化
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    // 字段自动填充
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;


}
