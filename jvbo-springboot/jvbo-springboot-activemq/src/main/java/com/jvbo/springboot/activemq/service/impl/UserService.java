/*
 * UserService.java 2017年6月8日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.activemq.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springboot.activemq.entity.User;
import com.jvbo.springboot.activemq.repository.UserRepository;
import com.jvbo.springboot.activemq.service.IUserService;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		return userRepository.getOne(id);
	}

	@Override
	public User save(User record) {
		User user = userRepository.save(record);
		return user;
	}
	
}
