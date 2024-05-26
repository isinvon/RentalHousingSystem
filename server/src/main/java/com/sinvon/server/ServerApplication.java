package com.sinvon.server;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@Slf4j
public class ServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServerApplication.class, args);
        System.out.println("\n" +
                "     _______. __  .__   __. ____    ____  ______   .__   __. \n" +
                "    /       ||  | |  \\ |  | \\   \\  /   / /  __  \\  |  \\ |  | \n" +
                "   |   (----`|  | |   \\|  |  \\   \\/   / |  |  |  | |   \\|  | \n" +
                "    \\   \\    |  | |  . `  |   \\      /  |  |  |  | |  . `  | \n" +
                ".----)   |   |  | |  |\\   |    \\    /   |  `--'  | |  |\\   | \n" +
                "|_______/    |__| |__| \\__|     \\__/     \\______/  |__| \\__| \n" +
                "                                                             \n");
        log.info("项目启动成功...");
    }

}
