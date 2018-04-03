/*
 * UserController.java 2017年6月4日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: UserController.java
 * @Package com.jvbo.cloud
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月4日
 */
package com.jvbo.springboot.activemq.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jvbo.springboot.activemq.amq.user.UserQueueProducer;
import com.jvbo.springboot.activemq.entity.User;
import com.jvbo.springboot.activemq.service.IUserService;

/**  
 * @ClassName: UserController 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月4日
 */
@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private UserQueueProducer userQueueProducer;
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return this.userService.findById(id);
	}
	
	@GetMapping("/user")
	public Boolean save(){
		User record = new User();
		record.setAge(Short.valueOf("1"));
		record.setBalance(BigDecimal.valueOf(1));
		record.setName("name");
		record.setUsername("username");
		//User user = userService.save(record);
		userQueueProducer.sendSave(JSON.toJSONString(record));
		return true;
	}
}
