/*
 * TopicSubscriber.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class TopicSubscriber {
	
	@JmsListener(destination = "sample.topic", containerFactory = "topicListenerFactory")
    public void receiveTopicMsg(String text) {
		System.out.println("TopicSubscriber:"+text);
    }
}
