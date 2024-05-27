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
     *
     * @param user
     * @return
     */
    @PostMapping("/register")
    public R<String> register(@RequestBody User user) {
        return userService.register(user);
    }

}
