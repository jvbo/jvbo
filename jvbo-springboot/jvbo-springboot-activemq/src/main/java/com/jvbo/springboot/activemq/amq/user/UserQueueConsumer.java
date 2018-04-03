/*
 * QueueConsumer.java 2017年6月22日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.amq.user;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jvbo.springboot.activemq.entity.User;
import com.jvbo.springboot.activemq.service.impl.UserService;

@Service
public class UserQueueConsumer {
	
	private static final Logger logger = LoggerFactory.getLogger(UserService.class); 
	
	@Autowired
	UserService userService;
	
	@JmsListener(destination = "user.queue", containerFactory = "queueListenerFactory")
	public void receiveSave(String msg) {
		logger.info("excute before db userList:{}",JSON.toJSONString(userService.findAll()));
		User user = JSONObject.toJavaObject(JSON.parseObject(msg), User.class);
		userService.save(user);
		logger.info("UserQueueConsumer receiveSave:{}", msg);
		logger.info("excute after db userList:{}",JSON.toJSONString(userService.findAll()));
	}
}
