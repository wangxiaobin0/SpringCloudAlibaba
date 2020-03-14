package com.cloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/9
 */
@Slf4j
@RestController
@RequestMapping("/provider")
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/{id}")
    public String get(@PathVariable("id") Long id) {
        String result = "端口: " + serverPort + "\t流水号: " + UUID.randomUUID().toString() + "\tid: " + id;
        log.info(result);
        return result;
    }
}
