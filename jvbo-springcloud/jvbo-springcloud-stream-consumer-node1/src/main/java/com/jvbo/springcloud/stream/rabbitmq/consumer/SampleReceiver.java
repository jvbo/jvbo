/*
 * SampleReceiver.java 2018年5月15日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springcloud.stream.rabbitmq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding
public class SampleReceiver {
    
    private static final Logger logger = LoggerFactory.getLogger(SampleReceiver.class);
    
    @StreamListener(Sink.INPUT)
    public void receive(Object payload){
        logger.info("received:{}", payload);
    }
}
