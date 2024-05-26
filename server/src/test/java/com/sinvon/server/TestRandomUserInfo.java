package com.sinvon.server;

import com.sinvon.server.utils.RandomUserInfo;
import org.junit.jupiter.api.Test;

/**
 * @Author: sinvon
 * @Date: 2024/05/25/下午5:25
 * @Description: 随机用户信息测试类
 */
public class TestRandomUserInfo {

    @Test
    public void randomUserInfoTest()
    {
        RandomUserInfo randomUserInfo = new RandomUserInfo();
        System.out.println("随机名字: " + randomUserInfo.getChineseName());
        System.out.println("随机英文名字: "+randomUserInfo.getRandomUserName());
        System.out.println("随机手机号: " + randomUserInfo.getTel());
        System.out.println("随机邮箱: " + randomUserInfo.getEmail(5,11));
        System.out.println("随机地址: " + randomUserInfo.getRoad());
        System.out.println("随机用户全部信息: " + randomUserInfo.getAllInfo());
        // 输出结果
        // 随机名字: 贲静
        // 随机英文名字: 2ipmkcn3
        // 随机手机号: 13104427497
        // 随机邮箱: sa763tjrdvm@263.net
        // 随机地址: 扬州街115号-15-4
        // 随机用户全部信息: {road=观海二广场101号-15-6, sex=女, name=颜丽, tel=13003355589, email=oqfoel0ny@googlemail.com, username=bju5d3y}

    }
}
