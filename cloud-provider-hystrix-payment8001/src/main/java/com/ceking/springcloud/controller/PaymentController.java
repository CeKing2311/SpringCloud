package com.ceking.springcloud.controller;

import com.ceking.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 14:05
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*********************Result:"+result+"********************");
        return  result;
    }

    /**
     * 延迟3秒响应，模拟网络故障
     * @param id
     * @return
     */
    @GetMapping("/payment/hystrix/timeout/{id}")
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*********************Result:"+result+"********************");
        return  result;
    }
    /************服务熔断**************/

    @GetMapping("/payment/hystrix/circuit/{id}")
    public  String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*********************Result:"+result+"********************");
        return  result;
    }

}
