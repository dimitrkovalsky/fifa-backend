package com.liberty;

import com.liberty.config.Config;
import com.liberty.config.WebSocketConfig;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author Dmytro_Kovalskyi.
 * @since 19.05.2016.
 */
@Slf4j
@SpringBootApplication
public class ServerRunner {

    public static void main(String[] args) {
        ConfigurableApplicationContext context =
                SpringApplication.run(new Class<?>[]{Config.class, WebSocketConfig.class}, args);

        log.info("Application started...");
    }
}
