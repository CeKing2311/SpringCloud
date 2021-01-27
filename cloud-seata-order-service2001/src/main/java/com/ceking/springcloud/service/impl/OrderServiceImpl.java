package com.ceking.springcloud.service.impl;

import com.ceking.springcloud.dao.OrderDao;
import com.ceking.springcloud.domain.Order;
import com.ceking.springcloud.service.AccountService;
import com.ceking.springcloud.service.OrderService;
import com.ceking.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 21:29
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao OrderDao;
    @Resource
    private AccountService accountService;
    @Resource
    private StorageService storageService;


    @Override
    //出现异常就回滚
    @GlobalTransactional(name = "fsp-create-order",rollbackFor = Exception.class)
    public void create(Order order) {
        log.info("------》创建订单");
        OrderDao.create(order);
        log.info("----->订单微服务调用库存，做扣减");
        storageService.decrease(order.getProductId(),order.getCount());
        log.info("----->订单微服务调用账户，做扣减");
        accountService.decrease(order.getUserId(),order.getMoney());
        log.info("----->修改订单状态");
        OrderDao.update(order.getUserId(),0);
        log.info("-----》订单创建完成!");
    }

}
