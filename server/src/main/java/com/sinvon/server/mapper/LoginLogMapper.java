package com.sinvon.server.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinvon.server.entity.LoginLog;
import org.apache.ibatis.annotations.Mapper;

/**
 * @Author: sinvon
 * @Date: 2024/05/30/下午4:47
 * @Description: 登录日志Mapper类
 */
@Mapper
public interface LoginLogMapper extends BaseMapper<LoginLog> {
}
