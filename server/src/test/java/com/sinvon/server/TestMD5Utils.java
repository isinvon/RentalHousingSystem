package com.sinvon.server;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;
import com.sinvon.server.utils.MD5Utils;
import org.junit.jupiter.api.Test;


/**
 * @Author: sinvon
 * @Date: 2024/05/27/上午10:37
 * @Description: MD5Utils测试类
 */
// @SpringBootTest
public class TestMD5Utils {
    private static final String password = "123456";
    private static final String salt = "sinvon";
    private static final String passwordMd5After = "e10adc3949ba59abbe56e057f20f883e";

    /**
     * 测试MD5加密
     */
    @Test
    public void testMD5encrypt() {
        MD5Utils md5Utils = new MD5Utils();
        String md5 = md5Utils.encrypt(password);
        System.out.println("md5加密之后的密码: " + md5);
    }

    /**
     * 测试盐值加密
     */
    @Test
    public void saltMD5Encryption(){
        // 生成16位的盐
        String salt = RandomUtil.randomString(16);
        // 拼接密码和盐
        String combinedPassword = password + salt;
        // md5加密
        String md5Password = SecureUtil.md5(combinedPassword);
        // 输出盐值加密后的密码
        System.out.println(md5Password);
    }
}
