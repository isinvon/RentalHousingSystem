package com.sinvon.server;

import com.sinvon.server.entity.User;
import com.sinvon.server.service.UserService;
import com.sinvon.server.service.impl.UserServiceImpl;
import com.sinvon.server.utils.sql.generate.UserGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午10:12
 * @Description: 随机用户信息插入到数据库测试类
 */

@SpringBootTest
@Slf4j
public class TestUserInsert {
    @Resource
    private UserService userService;


    /**
     * 插入用户信息到数据库
     */
    @Test
    public void UserInsert() {
        UserGenerator userGenerator = new UserGenerator();
        // 生成填充好信息的user对象
        User user = userGenerator.generateUser();
        System.out.println(user);
        // 插入数据库中
        boolean save = userService.save(user);
        if (save){
            log.info("插入用户信息到数据库中成功: {}", user);
        } else {
            log.info("插入用户信息到数据库失败");
        }
    }
}
