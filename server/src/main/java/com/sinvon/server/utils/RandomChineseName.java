package com.sinvon.server.utils;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;

import java.security.SecureRandom;
import java.util.Random;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午4:31
 * @Description: 随机生成中文姓名
 */
public class RandomChineseName {

    private static final int MIN_HANZI_CODE_POINT = 0x4E00; // 简体汉字的最小Unicode码点
    private static final int MAX_HANZI_CODE_POINT = 0x9FFF; // 简体汉字的最大Unicode码点

    // 创建一个中国姓氏的数组
    static String[] surname = {"林", "习", "范", "樊", "赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许", "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "彭", "郎", "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷", "罗", "毕", "郝",};
    // 创建一个随机汉字
    static char randomChinese = RandomUtil.randomChinese();
    // 创建一个随机数,从1和2中随机选择
    static int choice = RandomUtil.randomInt(1, 3);


    /**
     * 随机生成一个中文名字
     *
     * @return
     */
    public static String getRandomChineseName() {
        Random random = new Random();
        if (choice == 1) {
            // 将1个姓氏和1个汉字拼接成名字(2字)
            return StrUtil.join("", surname[random.nextInt(surname.length)], RandomUtil.randomChinese());
        } else if (choice == 2) {
            // 将1个姓氏和2个汉字拼接成名字(3字)
            return StrUtil.join("", surname[random.nextInt(surname.length)], RandomUtil.randomChinese(), RandomUtil.randomChinese());
        } else {
            // 将1个姓氏和3个汉字拼接成名字(4字)
            return StrUtil.join("", surname[random.nextInt(surname.length)], RandomUtil.randomChinese(), RandomUtil.randomChinese(), RandomUtil.randomChinese());
        }
    }

    /**
     * 随机生成指定长度的中文名字 (要求大于等于2字)
     *
     * @param length
     * @return
     */
    public static String getRandomChineseNameSelectLength(int length) {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        if (length >= 2) {
            for (int i = 0; i < length; i++) {
                if (i >= 2) {
                    stringBuilder.append(RandomUtil.randomChinese());
                }
            }
            // 返回拼接后的名字
            return StrUtil.join("", surname[random.nextInt(surname.length)], stringBuilder.toString());
        } else {
            throw new RuntimeException("长度不能小于2");
        }
    }


}
