package com.cloud.service;

import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
public interface IAccountService {
    /**
     * 扣钱
     * @param userId
     * @param money
     */
    void updateMoney(Long userId, Double money);
}
