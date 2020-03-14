package com.cloud.service.impl;

import com.cloud.dao.IAccountDao;
import com.cloud.service.IAccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.swing.text.AbstractDocument;
import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
@Slf4j
@Service
public class AccountServiceImpl implements IAccountService {
    @Resource
    IAccountDao accountDao;

    @Override
    public void updateMoney(Long userId, Double money) {
        log.info("扣钱.\t用户编号:" + userId + "金额: " + money);
        if (money > 1000) {
            throw new RuntimeException("余额不足");
        }
        accountDao.updateMoney(userId, money);
    }
}
