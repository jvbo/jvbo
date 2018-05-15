package com.jvbo.springcloud.config.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
public class ConfigController {
    
    @GetMapping("/profile")
    public String profile(){
        return "";
    }
}
