package com.ceking.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

/*
 *@author ceking
 *@description
 *@date 2021-1-26 13:49
 */
@Component
@EnableBinding(Sink.class)
public class ReceiveMessageController {
    @Value("${server.port}")
    private String serverPort;

    /**
     * 接收消息
     * @param message
     */
    @StreamListener(Sink.INPUT)
    public  void  input(Message<String> message){
        System.out.println("消费者："+serverPort+"---->收到的消息："+message.getPayload()+"\t");
    }
}
