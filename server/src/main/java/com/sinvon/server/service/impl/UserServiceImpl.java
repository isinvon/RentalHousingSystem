package com.sinvon.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinvon.server.entity.User;
import com.sinvon.server.mapper.UserMapper;
import com.sinvon.server.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 用户实现层
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public User register(User user) {
        return null;
    }


    @Override
    public User forgetPassword(User user) {
        return null;
    }
}
