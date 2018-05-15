package com.jvbo.springcloud.eureka.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jvbo.springcloud.eureka.entity.Order;
import com.jvbo.springcloud.eureka.repository.OrderRepository;
import com.jvbo.springcloud.eureka.service.IOrderService;

@Service
public class OrderService implements IOrderService {
    
    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order findById(Long id) {
        return orderRepository.findOne(id);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
    
}
