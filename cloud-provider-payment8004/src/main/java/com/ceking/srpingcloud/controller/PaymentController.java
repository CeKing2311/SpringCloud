package com.ceking.srpingcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author ceking
 * @desc
 * @date 2021/1/24 16:25
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private  String serverPort;

    @RequestMapping(value = "/payment/zk")
    public String paymentzk(){
        return  "spring cloud with zookeeper"+serverPort+"\t"+ UUID.randomUUID().toString();
    }


}
