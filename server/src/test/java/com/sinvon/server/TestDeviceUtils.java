package com.sinvon.server;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sinvon
 * @Date: 2024/05/29/下午2:01
 * @Description: 测试设备工具类
 */
@SpringBootTest
public class TestDeviceUtils {

    // 测试获取UA
    @Test
    public void getUA() {
        // deviceUtils.getUA();
    }

    @Test
    public void getDeviceInfo() {
        // UA示例
        String pcUserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1";
        // 移动端uA
        String mobileUserAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1";

        // 使用工具获取用户的UA

        // 通过使用工具解析UA, 获取设备类型
        UserAgent ua = UserAgentUtil.parse(pcUserAgent);

        // 返回设备类型
        String engine = ua.getEngine().toString(); // WebKit

        // 判断是否是移动端
        boolean mobile = ua.isMobile(); // true

        // 判断是否是PC
        String os = ua.getOs().toString(); // Windows

        // 判断浏览器类型
        String browser = ua.getBrowser().toString(); // Chrome

        // 获取系统版本
        String version = ua.getVersion().toString();

        // 获取平台
        String platform = ua.getPlatform().toString();// Windows

        // 将各个属性添加到映射中
        Map<String, Object> map = new HashMap<>();
        map.put("Engine", engine);
        map.put("isMobile", mobile);
        map.put("OS", os);
        map.put("Browser", browser);
        map.put("Version", version);
        map.put("Platform", platform);

        System.out.println(map);
    }
}
