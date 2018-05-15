package com.jvbo.springcloud.eureka.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.jvbo.springcloud.eureka.entity.Order;
import com.jvbo.springcloud.eureka.service.IOrderService;

@RestController
@RequestMapping("/order")
public class OrderController {
    
    @Autowired
    private IOrderService orderService;
    
    @GetMapping("/findAll")
    public String findAll(){
        List<Order> orderList = orderService.findAll();
        return JSON.toJSONString(orderList);
    }
}
