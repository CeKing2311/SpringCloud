package com.ceking.springcloud.controller;

import com.ceking.springcloud.entities.CommonResult;
import com.ceking.springcloud.entities.Payment;
import com.ceking.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author ceking
 * @desc
 * @date 2021/1/23 14:00
 */
@Slf4j
@RestController
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private  String serverPort;
    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment){
        int result= paymentService.create(payment);
        if (result>0){
            return  new CommonResult(200,"保存成功！"+serverPort,result);
        }else {
            return  new CommonResult(444,"保存失败!",null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        if (payment!=null){
            return  new CommonResult(200,"获取成功！"+serverPort,payment);
        }else {
            return  new CommonResult(444,"查询失败,查询ID:"+id,null);
        }
    }
    @GetMapping("/payment/discovery")
    public Object discovery(){
        //获取全部的微服务实例
        List<String> services = discoveryClient.getServices();
        for (String service:services){
            System.out.println("service info:"+service);
        }
        //获取指定的微服务实例
        List<ServiceInstance> instanceList = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance:instanceList){
            System.out.println(instance);
            //log.info("instance info:"+instance.getServiceId()+";"+instance.getHost()+";"+instance.getPort());
        }
        return  this.discoveryClient;
    }

    @GetMapping("/payment/lb")
    public String getPaymentLB(){
        return  serverPort;
    }

    /**
     * 测试Feign超时
     * @return
     */
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return  serverPort;
    }


}
