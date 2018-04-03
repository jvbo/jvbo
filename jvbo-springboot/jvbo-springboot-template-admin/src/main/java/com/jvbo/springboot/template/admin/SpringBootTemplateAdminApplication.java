package com.jvbo.springboot.template.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//@ServletComponentScan({"com.jvbo.springboot.template.admin"})//也支持java原生的servlet和filter
//@Import({DruidDataSourceConfig.class})
@SpringBootApplication
@MapperScan("com.jvbo.springboot.template.admin.core.mapper")
public class SpringBootTemplateAdminApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootTemplateAdminApplication.class, args);
	}
}
