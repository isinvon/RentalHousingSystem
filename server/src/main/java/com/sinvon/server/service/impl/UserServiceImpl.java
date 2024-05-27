package com.sinvon.server.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinvon.server.common.R;
import com.sinvon.server.entity.User;
import com.sinvon.server.mapper.UserMapper;
import com.sinvon.server.service.UserService;
import com.sinvon.server.utils.SHA256Utils;
import org.springframework.stereotype.Service;

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
    public R<String> register(User user) {
        // ------------------------------------------
        // 手机号, 邮箱, 用户名, 密码是否为空由前端判断    |
        // 用户名存在与否由前端无感判断,                 |
        // ------------------------------------------

        // 1.获取手机号
        String phone = user.getPhone();
        // 2.获取邮箱
        String email = user.getEmail();
        // 3.获取密码
        String password = user.getPassword();

        // 检查手机号和邮箱是否已存在
        User dbUser = this.getUserByPhoneOrEmail(phone, email);

        if (dbUser == null) {
            // 创建账户
            // 生成随机盐
            SHA256Utils sha256Utils = new SHA256Utils();
            String salt = sha256Utils.generateSalt(16);
            // 注入盐
            user.setSalt(salt);
            // 注入盐+密码拼接且SHA2加密后的密码
            user.setPassword(sha256Utils.saltEncrypt(salt, password));
            // 保存用户到数据库
            boolean isSaved = this.saveUser(user);
            if (isSaved) {
                return R.success("注册成功");
            } else {
                return R.error("注册失败，保存用户信息时出现问题");
            }
        } else {
            return R.error("注册失败，手机号或邮箱已被注册");
        }
    }


    @Override
    public User forgetPassword(User user) {
        return null;
    }
}
