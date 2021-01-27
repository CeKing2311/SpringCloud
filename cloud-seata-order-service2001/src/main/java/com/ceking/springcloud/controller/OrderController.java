package com.ceking.springcloud.controller;

import com.ceking.springcloud.domain.CommonResult;
import com.ceking.springcloud.domain.Order;
import com.ceking.springcloud.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ceking
 * @desc
 * @date 2021/1/27 21:39
 */
@RestController
@Slf4j
public class OrderController {

    @Resource
    OrderService orderService;

    @GetMapping("/order/create")
    public CommonResult create(Order order){
        System.out.println(order);
        orderService.create(order);
        return new CommonResult(200,"订单创建成功!");
    }



}
