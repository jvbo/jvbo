/*
 * Consumer.java 2017年6月21日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.example;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class QueueConsumer {
	
	@JmsListener(destination = "sample.queue", containerFactory = "queueListenerFactory")
	public void receiveQueueMsg(String text) {
		System.out.println("QueueConsumer:"+text);
	}
}
