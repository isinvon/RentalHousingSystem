package com.sinvon.server.utils;

import cn.hutool.http.useragent.UserAgent;
import cn.hutool.http.useragent.UserAgentUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: sinvon
 * @Date: 2024/05/29/下午1:52
 * @Description: 设备检测工具类
 */
public class DeviceUtils {


    /**
     * 获取设备User-Agent
     *
     * @return String
     */
    public static String getUA(HttpServletRequest httpRequest) {
        return httpRequest.getHeader("User-Agent");
    }


    /**
     * 获取设备信息
     * @return Map<String, Object>
     */
    public static Map<String, Object> getDeviceInfo(String userAgent) {
        // UA示例
        // String pcUserAgent = "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.1 (KHTML, like Gecko) Chrome/14.0.835.163 Safari/535.1";
        // 移动端uA
        // String mobileUserAgent = "Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1";

        // 使用工具获取用户的UA

        // 通过使用工具解析UA, 获取设备类型
        UserAgent ua = UserAgentUtil.parse(userAgent);

        // 返回设备类型
        String engine = ua.getEngine().toString(); // WebKit

        // 判断是否是移动端
        boolean mobile = ua.isMobile(); // true

        // 判断是否是PC
        String os = ua.getOs().toString(); // Windows

        // 判断浏览器类型
        String browser = ua.getBrowser().toString(); // Chrome

        // 获取系统版本
        String version = ua.getVersion();

        // 获取平台
        String platform = ua.getPlatform().toString();// Windows

        // 将各个属性添加到映射中
        Map<String, Object> map = new HashMap<>();
        map.put("Engine", engine);
        map.put("isMobile", mobile);
        map.put("OS", os);
        map.put("Version", version);
        map.put("Browser", browser);
        map.put("Platform", platform);

        // 返回映射
        return map;
    }
}
