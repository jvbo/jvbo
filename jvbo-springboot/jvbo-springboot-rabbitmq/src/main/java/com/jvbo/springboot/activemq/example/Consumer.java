/*
 * Consumer.java 2018年4月22日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.example;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Consumer {
    
    @RabbitHandler
    public void process(String hello) {
        System.out.println("Consumer : " + hello);
    }
}
