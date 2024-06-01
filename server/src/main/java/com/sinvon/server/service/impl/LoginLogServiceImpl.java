package com.sinvon.server.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinvon.server.entity.LoginLog;
import com.sinvon.server.mapper.LoginLogMapper;
import com.sinvon.server.service.LoginLogService;
import org.springframework.stereotype.Service;

/**
 * @Author: sinvon
 * @Date: 2024/05/30/下午4:49
 * @Description:
 */
@Service
public class LoginLogServiceImpl extends ServiceImpl<LoginLogMapper, LoginLog> implements LoginLogService {
}
