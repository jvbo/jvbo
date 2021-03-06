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
package com.jvbo.springboot.quartz.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.jvbo.springboot.quartz.entity.User;
import com.jvbo.springboot.quartz.service.IUserService;

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
	
	@GetMapping("/user/{id}")
	public User findById(@PathVariable Long id){
		return userService.findById(id);
	}
	
	@GetMapping("/user")
	public Boolean save(){
		User record = new User();
		record.setAge(Short.valueOf("1"));
		record.setBalance(BigDecimal.valueOf(1));
		record.setName("name");
		record.setUsername("username");
		//User user = userService.save(record);
		return true;
	}
	
	@GetMapping("/user/sampleTaskTwo")
	public void sampleTaskTwo(){
	    userService.sampleTaskTwo();
	}
}
