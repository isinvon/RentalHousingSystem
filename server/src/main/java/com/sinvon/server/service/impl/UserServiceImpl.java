package com.sinvon.server.service.impl;


import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinvon.server.common.R;
import com.sinvon.server.entity.LoginLog;
import com.sinvon.server.entity.User;
import com.sinvon.server.enums.LoginState;
import com.sinvon.server.mapper.UserMapper;
import com.sinvon.server.service.LoginLogService;
import com.sinvon.server.service.UserService;
import com.sinvon.server.utils.DeviceUtils;
import com.sinvon.server.utils.SHA256Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 用户实现层
 */
@Service
@Transactional
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private LoginLogService loginLogService;


    @Override
    public R<String> login(HttpServletRequest httpRequest, HttpServletResponse httpResponse, User user) {

        // 账号密码方式登录:

        // 获取手机号
        String phone = user.getPhone();

        // 获取邮箱
        String email = user.getEmail();

        // 获取密码
        String password = user.getPassword();

        // 通过手机号或者邮箱判断数据库中是否有这个用户,如果是手机号登录, 就通过手机号查询, 如果通过邮箱登录, 就通过邮箱查询
        User dbUser = getUserByPhoneOrEmail(phone, email);
        // 如果没有这个用户, 就返回R.error("用户不存在, 请注册账号")
        if (dbUser == null) {
            return R.error("用户不存在, 请注册账号");
        }
        // 如果有这个用户, 就判断密码是否正确
        // 从数据库中查询此用户的盐值
        String salt = dbUser.getSalt();
        // 将密码与盐值进行SHA256加密
        String encryptPassword = SHA256Utils.saltEncrypt(salt, password);
        // 将密码和从数据库中查询的密码比较, 查看是否一致
        if (encryptPassword.equals(dbUser.getPassword())) {
            // 如果正确
            // 并且记录登录日志
            LoginLog loginLog = new LoginLog();
            loginLog.setUserId(dbUser.getUserId());
            loginLog.setSessionId(httpRequest.getSession().getId().toString());
            // loginLog.getLogoutTime()
            loginLog.setIp(httpRequest.getRemoteAddr());
            // 获取用户设备信息
            String ua = DeviceUtils.getUA(httpRequest);
            Map<String, Object> browserInfoMap = DeviceUtils.getDeviceInfo(ua);
            loginLog.setBrowserInfo(browserInfoMap.toString());
            // 设置用户登录成功
            loginLog.setLoginStatus(LoginState.SUCCESS.getCode());
            // 用户插入数据库login_log表中
            loginLogService.save(loginLog);
            log.info("用户id: {} 登录成功",dbUser.getUserId());
            // 返回登录成功
            return R.success("登录成功");
        }
        // 密码不一致
        return R.error("登录失败,密码错误");
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
            // 生成随机盐(随机长度的密码)
            String salt = SHA256Utils.generateSalt(RandomUtil.randomInt(150, 200));
            // 注入盐
            user.setSalt(salt);
            // 注入盐+密码拼接且SHA2加密后的密码
            user.setPassword(SHA256Utils.saltEncrypt(salt, password));
            // 设置角色为普通用户
            user.setRole(2);
            // 激活账号
            user.setIsActive(1);
            // 设置基本积分
            user.setScore(100);
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

    /**
     * 根据id查询用户
     *
     * @param id
     * @return User
     */
    @Override
    public User getUserById(Long id) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getUserId, id));
    }

    /**
     * 根据用户名查询用户
     *
     * @param name
     * @return User
     */
    @Override
    public User getUserByName(String name) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getUsername, name));
    }

    /**
     * 根据邮箱查询用户
     *
     * @param email
     * @return User
     */
    @Override
    public User getUserByEmail(String email) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getEmail, email));
    }

    /**
     * 根据手机号查询用户
     *
     * @param phone
     * @return User
     */
    @Override
    public User getUserByPhone(String phone) {
        return getOne(new LambdaQueryWrapper<User>().eq(User::getPhone, phone));
    }

    /**
     * 根据手机号或邮箱查询用户
     *
     * @param phone
     * @param email
     * @return User
     */
    @Override
    public User getUserByPhoneOrEmail(String phone, String email) {
        // 查询逻辑，先按手机号查询，如果没有结果再按邮箱查询
        User dbUserByPhone = this.getUserByPhone(phone);
        if (dbUserByPhone != null) {
            return dbUserByPhone;
        }
        return this.getUserByEmail(email);
    }

    /**
     * 保存用户, 并且处理异常
     *
     * @param user
     * @return boolean
     */
    @Override
    public boolean saveUser(User user) {
        try {
            // 实际的保存逻辑，例如使用JPA、MyBatis或其他持久化框架
            this.save(user);
            return true;
        } catch (Exception e) {
            log.error("Error saving user", e);
            return false;
        }
    }


}
