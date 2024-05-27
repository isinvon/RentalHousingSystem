package com.sinvon.server.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.sinvon.server.common.R;
import com.sinvon.server.entity.User;
import com.sinvon.server.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    /**
     * 获取用户列表
     *
     * @return
     */
    @GetMapping("/list")
    public List<User> list() {
        return userService.list();
    }


    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R<String> register(@RequestBody User user) {
        // user为空则不创建
        if (!ObjectUtil.isAllEmpty(user)) {
            // 查看用户名是否存在
            if (userService.list(new LambdaQueryWrapper<User>().eq(User::getUsername, user.getUsername())).isEmpty()) {
                // 手机号是否存在
                if (userService.list(new LambdaQueryWrapper<User>().eq(User::getPhone, user.getPhone())).isEmpty()) {
                    // 邮箱是否存在
                    if (userService.list(new LambdaQueryWrapper<User>().eq(User::getEmail, user.getEmail())).isEmpty()) {
                        // 都不存在, 创建新账户
                        try {
                            User newUser = new User();
                            newUser.setUsername(user.getUsername());
                            newUser.setEmail(user.getEmail());
                            newUser.setPhone(user.getPhone());
                            newUser.setIsActive(1);
                            newUser.setPassword(user.getPassword());
                            userService.save(newUser);
                            log.info("成功创建了一个新用户: {}", user);
                            return R.success("用户创建成功");
                        } catch (Exception e) {
                            log.error("创建用户失败: {}", e.getMessage());
                        }
                    }else {
                        return R.error("邮箱已存在, 请换一个邮箱");
                    }
                } else {
                    return R.error("手机号已存在, 请换一个手机号");
                }
            } else {
                // 返回给客户端告诉用户用户名已存在
                return R.error("用户名已存在, 请换一个用户名");
            }
        }
        return R.error("用户信息为空, 请确认用户信息是否正确");
    }


}
