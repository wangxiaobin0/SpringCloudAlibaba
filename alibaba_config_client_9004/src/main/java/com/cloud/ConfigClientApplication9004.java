package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

/**
 * @author
 * @date 2020/3/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication9004 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication9004.class, args);
    }
}
