/*
 * QueueProducer.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.amq.user;

import javax.jms.Queue;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.activemq.service.impl.UserService;

@Service
public class UserQueueProducer {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class); 
	
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue queue;
	
	
	public void sendSave(String msg){
		this.queue = new ActiveMQQueue("user.queue");
		jmsMessagingTemplate.convertAndSend(this.queue, msg);
		logger.info("UserQueueProducer sendSave:{}", msg);
	}

}
