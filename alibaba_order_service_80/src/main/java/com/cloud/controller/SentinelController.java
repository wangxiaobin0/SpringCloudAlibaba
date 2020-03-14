package com.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.cloud.service.ISentinelService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/11
 */
@Slf4j
@RestController
public class SentinelController {

    @Autowired
    ISentinelService sentinelService;
    @GetMapping("/sentinel")
    public String getInfo() throws InterruptedException {
        String info = sentinelService.getInfo();
        log.info(info);
        return info;
    }


    @GetMapping("/sentinel/related")
    public String testRelated() {
        String info = sentinelService.testRelated();
        log.info(info);
        return info;
    }


}
