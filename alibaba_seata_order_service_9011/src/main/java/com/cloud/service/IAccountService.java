package com.cloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
@FeignClient(value = "alibaba-seata-account-service")
public interface IAccountService {

    /**
     * 扣钱
     * @param userId    用户id
     * @param money 金额
     */
    @PostMapping("/account")
    void updateResidue(@RequestParam("userId") Long userId, @RequestParam("money") Double money);
}
