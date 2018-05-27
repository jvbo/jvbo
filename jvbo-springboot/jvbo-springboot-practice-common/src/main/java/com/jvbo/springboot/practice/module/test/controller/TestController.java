/*
 * TestController.java 2018年5月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jvbo.springboot.practice.core.manager.test.ITestManager;

@RestController
@RequestMapping("/test/test")
public class TestController {
    
    @Autowired
    private ITestManager testManager;
    
}
