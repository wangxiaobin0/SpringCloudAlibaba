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
public class SentinelApplication9005 {
    public static void main(String[] args) {
        SpringApplication.run(SentinelApplication9005.class, args);
    }
}
