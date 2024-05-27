package com.sinvon.server;

import cn.hutool.crypto.SecureUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author: sinvon
 * @Date: 2024/05/27/下午8:15
 * @Description:
 */
public class TestSHA256Utils {


    // 测试SHA256加密
    @Test
    public void testSHA256encrypt()
    {
        String password = "123456";
        String encrypt = SecureUtil.sha256(password);
        System.out.println(encrypt);
    }


    // 测试加盐SHA256加密
    @Test
    public void testSaltSHA256Encryption()
    {
        String password = "123456";
        String salt = "salt";
        String combinePasswordAndSalt = password + salt;
        String encrypt = SecureUtil.sha256(combinePasswordAndSalt);
        System.out.println(encrypt);
    }


}
