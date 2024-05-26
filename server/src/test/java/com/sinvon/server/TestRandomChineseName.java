package com.sinvon.server;

import com.sinvon.server.utils.RandomChineseName;
import org.junit.jupiter.api.Test;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午4:37
 * @Description: 随机中文名测试类
 */
public class TestRandomChineseName {
    /**
     * ]
     * 随机生成中文姓名
     */
    @Test
    public void randomChineseNameTest() {
        RandomChineseName randomChineseName = new RandomChineseName();
        System.out.println(randomChineseName.getRandomChineseName());
        System.out.println(randomChineseName.getRandomChineseName());
        System.out.println(randomChineseName.getRandomChineseName());
        // 输出结果:
        // 倪肐
        // 陶榌
        // 喻籙
    }

    /**
     * 随机生成指定长度的中文姓名
     */
    @Test
    public void randomChineseNameLengthTest() {
        RandomChineseName randomChineseName = new RandomChineseName();
        System.out.println(randomChineseName.getRandomChineseNameSelectLength(10));
        System.out.println(randomChineseName.getRandomChineseNameSelectLength(10));
        System.out.println(randomChineseName.getRandomChineseNameSelectLength(10));
        // 输出结果:
        // 袁囵龬騬陔騬琑琀琡
        // 姜餶坐蛜蝛寅倞匭棈
        // 岑铩測鼮咉芉薕趨鎄
    }

}
