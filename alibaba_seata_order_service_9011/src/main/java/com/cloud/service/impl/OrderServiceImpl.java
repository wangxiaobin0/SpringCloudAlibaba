package com.cloud.service.impl;

import com.cloud.dao.IOrderDao;
import com.cloud.domain.CommonResult;
import com.cloud.domain.Order;
import com.cloud.service.IAccountService;
import com.cloud.service.IOrderService;
import com.cloud.service.IStorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author
 * @date 2020/3/12
 */
@Slf4j
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    IOrderDao orderDao;

    @Resource
    IStorageService storageService;

    @Resource
    IAccountService accountService;

    @Autowired
    RestTemplate restTemplate;

    @Override
    @GlobalTransactional(name = "createOrder", rollbackFor = Throwable.class)
    public void createOrder(Order order) {
        log.info("开始创建订单" + order);
        //创建订单
        orderDao.createOrder(order);
        //减库存
        log.info("减库存.\t产品编号:" + order.getProductId() + "\t购买数量:" + order.getCount());
        storageService.updateStorage(order.getProductId(), order.getCount());
        //扣款
        log.info("扣钱.\t用户编号:" + order.getUserId() + "\t金额:" + order.getMoney());
        accountService.updateResidue(order.getUserId(), order.getMoney());
        //更新订单状态
        log.info("更新订单状态.\t用户编号" + order.getUserId());
        orderDao.updateOrder(order.getUserId(),  order.getStatus());
        //添加订单成功
        log.info("新增订单成功");
    }
}
