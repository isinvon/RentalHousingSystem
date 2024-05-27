package com.sinvon.server.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @Author: sinvon
 * @Date: 2024/05/27/下午8:05
 * @Description: SHA256加密工具类
 */
public class SHA256Utils {

    /**
     * sha255直接加密
     * @param password
     * @return
     */
    public String encrypt(String password) {
        return SecureUtil.sha256(password);
    }


    /**
     * salt+password加密
     *
     * @param salt
     * @param password
     * @return String
     */
    public String saltEncrypt(String salt, String password) {
        // 拼接密码和盐
        String combinedPassword = password + salt;
        // 返回sha256加密
        return SecureUtil.sha256(combinedPassword);
    }


    /**
     * 生成盐salt
     *
     * @param length
     * @return String
     */
    public String generateSalt(int length) {
        return RandomUtil.randomString(length);
    }
}
