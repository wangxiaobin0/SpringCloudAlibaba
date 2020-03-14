package com.cloud.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;

/**
 * @author
 * @date 2020/3/11
 */
@Slf4j
public class MyBlockExceptionHandler {

    public static String exceptionHandler(BlockException e) {
        log.info(e.getClass().getCanonicalName());
        return "自定义BlockExceptionHandler exceptionHandler----------1";
    }


    public static String exceptionHandler2(BlockException e) {
        log.info(e.getClass().getCanonicalName());
        return "自定义BlockExceptionHandler exceptionHandler----------2";
    }
}
