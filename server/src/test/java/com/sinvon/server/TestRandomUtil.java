package com.sinvon.server;

import cn.hutool.core.util.RandomUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午4:00
 * @Description: hutool的随机工具RandomUtil测试类
 */
public class TestRandomUtil {

    /**
     * 随机生成中文
     */
    @Test
    public void randomChineseTest() {
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        System.out.println(RandomUtil.randomChinese());
        // 输出结果:
        // 螂
        // 嫴
        // 捕
        // 橁
        // 莜
        // 筓
        // 讐
    }

    /**
     * 随机生成数字
     */
    @Test
    public void randomNumbersTest() {
        System.out.println(RandomUtil.randomNumbers(6));
        System.out.println(RandomUtil.randomNumbers(3));
        System.out.println(RandomUtil.randomNumbers(1));
        System.out.println(RandomUtil.randomNumbers(100));
        // 输出结果:
        // 449259
        // 356
        // 3
        // 5488873691120757737907077470023523671816903200967138216042828381790969263247356777328675497345345781
    }

    /**
     * 随机生成字符串
     */
    @Test
    public void randomStringTest() {
        System.out.println(RandomUtil.randomString(6));
        System.out.println(RandomUtil.randomString(3));
        System.out.println(RandomUtil.randomString(1));
        System.out.println(RandomUtil.randomString(100));
        // 输出结果:
        // zMeVM3
        // SfU
        // E
        // QZe1yf52ImtlXyIfd0U8tFrmSOuwtXGsXduYqYaTUoaQa73nxPVGGSzroyYzCVJaLWi1nHuuk4aF5hjrOrQNwz7y8pHm7hY0oJia
    }

    /**
     * 随机生成布尔值
     */
    @Test
    public void randomBooleanTest() {
        System.out.println(RandomUtil.randomBoolean());
        System.out.println(RandomUtil.randomBoolean());
        // 输出结果:
        // true
        // true
    }

    /**
     * 随机生成int
     */
    @Test
    public void randomIntTest() {
        System.out.println(RandomUtil.randomInt(1, 100));
        System.out.println(RandomUtil.randomInt(1, 10));
        // 输出结果:
        // 4
        // 3
    }

    /**
     * 随机生成long
     */
    @Test
    public void randomLongTest() {
        System.out.println(RandomUtil.randomLong(1, 100));
        System.out.println(RandomUtil.randomLong(1, 10000));
        System.out.println(RandomUtil.randomLong(1, 1000000000L));
        System.out.println(RandomUtil.randomLong(1, 10));
        // 输出结果:
        // 88
        // 1413
        // 914046741
        // 6
    }

    /**
     * 随机生成double
     */
    @Test
    public void randomDoubleTest() {
        System.out.println(RandomUtil.randomDouble(1, 100));
        System.out.println(RandomUtil.randomDouble(1, 10000));
        System.out.println(RandomUtil.randomDouble(1, 1000000000));
        System.out.println(RandomUtil.randomDouble(1, 10));
        // 输出结果:
        // 39.08264825342763
        // 5670.089384750805
        // 2.3244042346490592E8
        // 5.7704713167983614
    }


}
