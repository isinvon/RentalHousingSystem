package com.sinvon.server.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinvon.server.common.R;
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
    public R<String> register(User user);

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



    /**
     * 根据email获取单个用户信息
     * @param email
     * @return
     */
    public User getUserByEmail(String email);

    /**
     * 根据phone获取单个用户信息
     * @param phone
     * @return
     */
    public User getUserByPhone(String phone);

    /**
     * 根据phone或者email获取单个用户信息
     * @param phone
     * @param email
     * @return
     */
    public User getUserByPhoneOrEmail(String phone, String email);

    /**
     * 保存用户, 并处理异常
     * @param user
     * @return
     */
    public boolean saveUser(User user);


}
