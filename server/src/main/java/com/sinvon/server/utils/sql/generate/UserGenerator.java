package com.sinvon.server.utils.sql.generate;

import cn.hutool.core.util.CharUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import com.sinvon.server.entity.User;
import com.sinvon.server.enums.UserState;
import com.sinvon.server.service.UserService;
import com.sinvon.server.utils.RandomUserInfo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午12:56
 * @Description:
 */

@Slf4j
public class UserGenerator {


    public User generateUser() {
        User user = new User();
        Random random = new Random();
        RandomUserInfo randomUserInfo = new RandomUserInfo();
        // UUID生成id
        String UUIDRandom = UUID.randomUUID().toString().replace("-", "");
        // 雪花算法生成ID
        long id = IdUtil.getSnowflakeNextId();


        // 设置id
        user.setUserId(id);
        // 设置用户名
        user.setUsername(randomUserInfo.getRandomUserName());
        //设置姓名
        user.setFullname(randomUserInfo.getChineseName());
        // 设置密码
        user.setPassword("123456");
        // 设置邮箱
        user.setEmail(randomUserInfo.getEmail(6,11));
        // 设置手机号
        user.setPhone(randomUserInfo.getTel());
        // 设置积分
        user.setScore(RandomUtil.randomInt(300,500)); // 随机积分 nextInt(100)代表0-99的随机数
        // 设置角色
        user.setRole(UserState.TENANT.getCode());
        // 设置激活状态
        user.setIsActive(UserState.ACTIVE.getCode());
        // 创建时间
        user.setCreateTime(LocalDateTime.now());
        // 修改时间
        user.setUpdateTime(LocalDateTime.now());
        log.info("User用户信息生成成功: {}", user);
        // System.out.println("user: "+user);
        return user;
    }
}
