package com.jvbo.springcloud.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SpringCloudEurekaClientUserApplication {
    
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaClientUserApplication.class, args);
	}
}
