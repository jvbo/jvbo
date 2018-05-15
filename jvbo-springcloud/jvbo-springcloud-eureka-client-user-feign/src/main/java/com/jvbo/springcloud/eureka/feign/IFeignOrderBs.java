package com.jvbo.springcloud.eureka.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("jvbo-springcloud-eureka-client-order")
@RequestMapping("/order")
public interface IFeignOrderBs {
    
    @GetMapping("/findAll")
    String findAll();
    
}
