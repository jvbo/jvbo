/*
 * TestController.java 2018年5月10日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.practice.module.test.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jvbo.springboot.practice.core.enums.ResponseStatusEnum;
import com.jvbo.springboot.practice.core.manager.test.ITestManager;
import com.jvbo.springboot.practice.framework.response.Response;
import com.jvbo.springboot.practice.framework.response.ResponseBuilder;

@RestController
@RequestMapping("/test/test")
public class TestController {
    
    @Autowired
    private ITestManager testManager;
    
    @RequestMapping(value = "/batchInsert", method = {RequestMethod.GET, RequestMethod.POST})
    public Response<String> batchInsert(){
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            boolean flag = testManager.batchInsert();
            return String.valueOf(flag);
        });
    }
    
    @RequestMapping(value = "/execTime", method = {RequestMethod.GET, RequestMethod.POST})
    public Response<String> execTime(){
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            BigDecimal time = testManager.execTime();
            return String.valueOf(time);
        });
    }
    
    @RequestMapping(value = "/transaction", method = {RequestMethod.GET, RequestMethod.POST})
    public Response<String> transaction(){
        return ResponseBuilder.create().defaultError(ResponseStatusEnum.ERR_LOAD.getCode(), "加载出错!").buildResponse(() -> {
            String time = testManager.transaction();
            return String.valueOf(time);
        });
    }
}
