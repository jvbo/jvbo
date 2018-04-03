/*
 * UserRepository.java 2017年6月3日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
/**  
 * @Title: UserRepository.java
 * @Package com.jvbo.cloud
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月3日
 */
package com.jvbo.springboot.activemq.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jvbo.springboot.activemq.entity.User;

/**  
 * @ClassName: UserRepository 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月3日
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
