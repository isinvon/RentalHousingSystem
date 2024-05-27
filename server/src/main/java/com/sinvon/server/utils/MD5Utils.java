package com.sinvon.server.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.SecureUtil;

/**
 * @Author: sinvon
 * @Date: 2024/05/27/上午10:29
 * @Description: MD5加密工具类
 */
public class MD5Utils {


    /**
     * MD5直接加密
     * @param password
     * @return
     */
    public String encrypt(String password) {
        return SecureUtil.md5(password);
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
        // 返回md5加密后的密码
        return SecureUtil.md5(combinedPassword);
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
