package com.skycloud.service.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 *
 * @author
 */
@EnableFeignClients(basePackages = "com.skycloud")
@ComponentScan(basePackages = "com.skycloud")
@SpringBootApplication
public class SkyCloudOrderProxyApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(SkyCloudOrderProxyApplication.class, args);
    }

}
