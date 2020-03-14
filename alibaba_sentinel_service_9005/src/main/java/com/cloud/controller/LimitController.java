package com.cloud.controller;

import cn.hutool.core.lang.UUID;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.cloud.handler.MyBlockExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author
 * @date 2020/3/11
 */
@Slf4j
@RestController
@RequestMapping("/limit")
public class LimitController {

    @GetMapping("/resource")
    @SentinelResource(value = "resource", blockHandler = "byResourceBlockHandler")
    public String byResource() {
        String result = "按@SentinelResource资源限流\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }

    public String byResourceBlockHandler(BlockException e) {
        String result = "按@SentinelResource资源限流\t异常回调\t";
        log.info(e.getClass().getCanonicalName());
        return result;
    }

    @GetMapping("/url")
    @SentinelResource("url")
    public String byUrl() {
        String result = "按@RequestMappingURL限流\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }

    @GetMapping("/handler")
    @SentinelResource(value = "handler", blockHandlerClass = MyBlockExceptionHandler.class, blockHandler = "exceptionHandler2")
    public String byHandler() {
        String result = "自定义BlockExceptionHandler限流\t" + UUID.randomUUID().toString();
        log.info(result);
        return result;
    }
}
