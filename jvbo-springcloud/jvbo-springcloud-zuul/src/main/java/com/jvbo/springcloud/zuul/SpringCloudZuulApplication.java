package com.jvbo.springcloud.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

import com.jvbo.springcloud.zuul.filter.AccessFilter;

@EnableZuulProxy
@SpringCloudApplication
public class SpringCloudZuulApplication {
    
    @Bean
    public AccessFilter accessFilter(){
        return new AccessFilter();
    }
    
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}
}
