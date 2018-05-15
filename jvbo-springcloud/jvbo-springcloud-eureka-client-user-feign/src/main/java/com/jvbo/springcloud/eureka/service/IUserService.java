/*
 * IMovieService.java 2017年6月8日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springcloud.eureka.service;

import java.util.List;

import com.jvbo.springcloud.eureka.entity.User;

public interface IUserService {
	List<User> findAll();
	User findById(Long id);
	User save(User record);
}
