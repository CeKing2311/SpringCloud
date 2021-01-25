package com.ceking.springcloud.controller;

import com.ceking.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *@author ceking
 *@description
 *@date 2021-1-25 14:41
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod")
public class OrderHystrixController {

    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/consumer/payment/hystrix/ok/{id}")
    public  String paymentInfo_OK(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfo_OK(id);
        log.info("*********************Result:"+result+"********************");
        return  result;
    }

    /**
     * 延迟1.5秒响应，模拟网络故障
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymentInfo_TimeOutHandlerMethod", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1500")
    })*/
    @HystrixCommand
    public  String paymentInfo_TimeOut(@PathVariable("id") Integer id){
        int i=10/0;
        String result = paymentService.paymentInfo_TimeOut(id);
        log.info("*********************Result:"+result+"********************");
        return  result;
    }
    public String paymentInfo_TimeOutHandlerMethod(Integer id) {
        return "消费者80,服务器繁忙，请10秒钟后再试,o(╥﹏╥)o";
    }

    public String payment_Global_FallbackMethod(){
        return "Global异常处理,服务器繁忙，请10秒钟后再试,o(╥﹏╥)o";
    }


}
