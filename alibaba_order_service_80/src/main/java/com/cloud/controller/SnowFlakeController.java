package com.cloud.controller;

import com.cloud.util.SnowFlakeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author
 * @date 2020/3/13
 */
@RestController
public class SnowFlakeController {
    @Autowired
    SnowFlakeUtil snowFlakeUtil;
    @GetMapping("/sf")
    public String sf() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(()->{
                    System.out.println(snowFlakeUtil.snowFlake());
            });
        }
        executorService.shutdown();
        return "nihao";
    }
}
