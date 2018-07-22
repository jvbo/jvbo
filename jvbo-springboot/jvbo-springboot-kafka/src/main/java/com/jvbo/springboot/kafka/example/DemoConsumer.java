/*
 * DemoConsumer.java 2018年6月28日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.kafka.example;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class DemoConsumer {
    
    @KafkaListener(topics = "test", groupId="group-consumer-test")
    public void demoConsumer(ConsumerRecord<String, String> record){
        System.out.println(record.value());
    }
}
