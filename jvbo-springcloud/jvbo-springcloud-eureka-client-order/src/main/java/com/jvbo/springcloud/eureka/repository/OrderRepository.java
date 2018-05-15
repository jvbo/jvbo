package com.jvbo.springcloud.eureka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jvbo.springcloud.eureka.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
