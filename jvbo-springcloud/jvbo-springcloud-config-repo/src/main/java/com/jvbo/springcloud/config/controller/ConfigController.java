package com.jvbo.springcloud.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;

@RestController
@RequestMapping("/config")
public class ConfigController {
    
    @GetMapping("/appName")
    public String appName(){
        JSONObject jo = new JSONObject();
        jo.put("appName", "jvbo-springcloud-config-client");
        return jo.toString();
    }
}
