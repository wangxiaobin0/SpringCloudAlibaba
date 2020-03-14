package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @date 2020/3/10
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ConfigClientApplication9003 {
    public static void main(String[] args) {
        SpringApplication.run(ConfigClientApplication9003.class, args);
    }
}
