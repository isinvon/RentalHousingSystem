package com.sinvon.server;

import cn.hutool.core.util.IdUtil;
import org.junit.jupiter.api.Test;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午3:21
 * @Description: 雪花算法id生成测试类
 */
public class TestSnowFlakeUtil {

    @Test
    public void generateID() {
        long id = IdUtil.getSnowflakeNextId();
        System.out.println(id);
        long id2 = IdUtil.getSnowflakeNextId();
        System.out.println(id2);
        long id3 = IdUtil.getSnowflakeNextId();
        System.out.println(id3);

    }
    @Test
    public void generateIDStr() {
        String id = IdUtil.getSnowflakeNextIdStr();
        System.out.println(id);
        String id2 = IdUtil.getSnowflakeNextIdStr();
        System.out.println(id2);
        String id3 = IdUtil.getSnowflakeNextIdStr();
        System.out.println(id3);
        System.out.println("===========以下是类型getClass()============");
        // 查看类型
        System.out.println(id.getClass());
        System.out.println(id2.getClass());
        System.out.println(id3.getClass());
        System.out.println("===========以下是getClass().getName()============");
        System.out.println(id.getClass().getName());
        System.out.println(id2.getClass().getName());
        System.out.println(id3.getClass().getName());
        System.out.println("=========以下是getClass().getTypeName()==========");
        System.out.println(id.getClass().getTypeName());
        System.out.println(id2.getClass().getTypeName());
        System.out.println(id3.getClass().getTypeName());
    }

}
