package com.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/10
 */
@Slf4j
@RestController
@RefreshScope
public class ConfigController {

    @Value("${server.port}")
    String serverPort;

    @Value("${config.info}")
    String configInfo;

    @GetMapping("/config")
    public String getInfo() {
        String result = "端口: " + serverPort + "\t" + configInfo;
        log.info(result);
        return result;
    }
}
