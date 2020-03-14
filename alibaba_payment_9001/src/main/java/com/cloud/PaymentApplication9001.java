package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author
 * @date 2020/3/9
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentApplication9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9001.class, args);
    }
}
