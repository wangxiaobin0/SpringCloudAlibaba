package com.cloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author
 * @date 2020/3/12
 */
@Mapper
public interface IAccountDao {
    /**
     * 扣钱
     * @param userId
     * @param money
     */
    void updateMoney(@Param("userId") Long userId, @Param("money") Double money);
}
