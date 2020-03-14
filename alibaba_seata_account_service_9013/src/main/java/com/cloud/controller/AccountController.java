package com.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.cloud.domain.CommonResult;
import com.cloud.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
@Slf4j
@RestController
public class AccountController {

    @Autowired
    IAccountService accountService;

    @PostMapping("/account")
    @SentinelResource(value = "account", fallback = "accountFallBack")
    public CommonResult updateMoney(@RequestParam("userId") Long userId, @RequestParam("money") Double money) {
        accountService.updateMoney(userId, money);
        return new CommonResult("200", "扣钱成功");
    }

    public CommonResult accountFallBack(Long userId, BigDecimal money, Throwable throwable) {
        log.info(throwable.getClass().getCanonicalName());
        return new CommonResult("500", "扣钱失败");
    }
}
