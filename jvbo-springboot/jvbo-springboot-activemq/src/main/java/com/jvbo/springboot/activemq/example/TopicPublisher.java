/*
 * TopicPublisher.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.example;

import javax.jms.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class TopicPublisher {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;

	@Autowired
    private Topic topic;
	
	@Scheduled(fixedDelay = 3000)
    public void send() {
		String msg = "TopicPublisher to activeMq!!!";
		System.out.println("TopicPublisher:" + msg);
        this.jmsMessagingTemplate.convertAndSend(this.topic, msg);
    }
}
