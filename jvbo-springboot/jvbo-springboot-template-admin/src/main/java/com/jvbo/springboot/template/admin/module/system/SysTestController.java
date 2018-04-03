/*
 * SysIndexController.java 2017年10月12日
 * Copyright (c) 2015-2016, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.template.admin.module.system;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class SysTestController {
	
	private static final Logger logger = LoggerFactory.getLogger(SysTestController.class);
	
	@RequestMapping("/home")
	public String home(ModelMap map){
		logger.info("enter");
		map.addAttribute("host", "http://www.baidu.com");
		return "test-home";
	}
	
}
