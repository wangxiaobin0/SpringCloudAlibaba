package com.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author
 * @date 2020/3/10
 */
@Slf4j
@RestController
public class SentinelController {

    @Value("${server.port}")
    String serverPort;

    @GetMapping("/sentinel")
    public String getInfo() throws InterruptedException {
        String result = "端口 : " + serverPort + "\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }


    @GetMapping("/sentinel/related")
    public String testRelated() {
        String result = "端口 : " + serverPort + "\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }
    @GetMapping("/sentinel/d")
    public String testD() {
        try {
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int i = 1 / 0;

        String result = "服务降级\t端口 : " + serverPort + "\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }

    @GetMapping("/hotkey")
    @SentinelResource(value = "hotkey", blockHandler = "hotKeyHandler")
    public String testHotKey() {
        String result = "服务降级---hotKey---\t端口 : " + serverPort + "\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }

    public String hotKeyHandler(BlockException e) {
        System.out.println(e);
        String result = "HotKeyHandler-------热点限流处理";
        return result;
    }

}
