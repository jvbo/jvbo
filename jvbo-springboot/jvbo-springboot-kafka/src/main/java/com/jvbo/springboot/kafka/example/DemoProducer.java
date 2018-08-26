/*
 * DemoProducer.java 2018年6月28日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.kafka.example;

import java.time.Instant;
import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.producer.RecordMetadata;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

@Component
public class DemoProducer {
    private static final Logger logger = LoggerFactory.getLogger(DemoProducer.class);
    
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    
    public void demoProducer(){
        for (int i = 0; i < 1000; i++) {
            String topic = "test";
            String key = "test".concat(String.valueOf(Instant.now().toEpochMilli()));
            String value = "value";
            ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send(topic, key, value);
            try {
                SendResult<String, String> sendResult = future.get();
                RecordMetadata recordMetadata = sendResult.getRecordMetadata();
                logger.info("recordMetadata.partition():{}, recordMetadata.offset():{}", recordMetadata.partition(), recordMetadata.offset());
            } catch (InterruptedException | ExecutionException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
