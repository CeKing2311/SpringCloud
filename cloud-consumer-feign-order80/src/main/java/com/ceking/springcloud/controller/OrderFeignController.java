package com.ceking.springcloud.controller;

import com.ceking.springcloud.entities.CommonResult;
import com.ceking.springcloud.entities.Payment;
import com.ceking.springcloud.service.PaymentFeignService;
import org.apache.logging.log4j.message.ReusableMessage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 10:42
 */
@RestController
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        CommonResult<Payment> payment = paymentFeignService.getPaymentById(id);
        return  payment;
    }
    @GetMapping("/consumer/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        //客户端默认等待1秒钟
        return  paymentFeignService.paymentFeignTimeOut();
        //return  "请求超时!";
    }

}
