package com.ceking.springcloud.controller;

import com.ceking.springcloud.service.IMessageProvider;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/*
 *@author ceking
 *@description
 *@date 2021-1-26 11:39
 */
@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    /**
     * 发送消息
     * @return
     */
    @GetMapping("/sendMessage")
    public String sendMessage(){
        return  messageProvider.send();
    }
}
