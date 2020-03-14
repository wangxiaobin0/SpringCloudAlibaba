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
public class PaymentApplication9002 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentApplication9002.class, args);
    }
}
