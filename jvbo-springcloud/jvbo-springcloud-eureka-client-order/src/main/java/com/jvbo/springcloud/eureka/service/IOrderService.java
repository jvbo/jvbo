package com.jvbo.springcloud.eureka.service;

import java.util.List;

import com.jvbo.springcloud.eureka.entity.Order;

public interface IOrderService {
    Order findById(Long id);
    List<Order> findAll();
}
