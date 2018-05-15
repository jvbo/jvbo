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
package com.jvbo.springcloud.eureka.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.jvbo.springcloud.eureka.service.IUserService;

/**  
 * @ClassName: UserController 
 * @Description: TODO
 * @author jvbo
 * @date 2017年6月4日
 */
@RestController
@RequestMapping("/user")
public class UserController {
    
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private IUserService userService;
	@Autowired
	private LoadBalancerClient loadBalancerClient;
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/findAll")
	public String findAll(){
		return JSON.toJSONString(userService.findAll());
	}
	
	@GetMapping("/rmiOrder")
	public String rmiOrder(){
	    ServiceInstance serviceInstance = loadBalancerClient.choose("jvbo-springcloud-eureka-client-order");
	    String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/order/findAll";
	    logger.info("url:{}", url);
	    return restTemplate.getForObject(url, String.class);
	}
}
