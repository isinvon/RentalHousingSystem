package com.sinvon.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinvon.server.entity.User;

/**
 * 用户接口层
 */


public interface UserService extends IService<User> {

    /**
     * 登录
     */
    public User login(User user);

    /**
     * 注册
     */
    public User register(User user);

    /**
     * 忘记密码
     */
    public User forgetPassword(User user);

    /**
     * 根据id获取单个用户信息
     * @param id
     * @return
     */
    public User getUserById(Long id);


}
