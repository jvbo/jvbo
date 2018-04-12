/*
 * TestController.java 2018年4月11日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.ucenter.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ucenter/test")
public class TestController {
private static final Logger logger = LoggerFactory.getLogger(TestController.class);
    
    @RequestMapping("/home")
    public String home(ModelMap map){
        logger.info("enter");
        map.addAttribute("host", "http://www.baidu.com");
        return "test-home";
    }
}
