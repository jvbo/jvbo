package com.jvbo.springcloud.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.jvbo.springcloud.gateway.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class SpringCloudGatewayApplication {
    
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGatewayApplication.class, args);
	}
}
