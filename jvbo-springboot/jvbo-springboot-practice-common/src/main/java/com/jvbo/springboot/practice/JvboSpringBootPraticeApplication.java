package com.jvbo.springboot.practice;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.jvbo.springboot.practice.framework.base.BaseInterface;
import com.jvbo.springboot.practice.framework.exception.MvcExceptionHandler;
import com.jvbo.springboot.practice.framework.listener.BaseServiceInitApplicationReadyListener;
import com.jvbo.springboot.practice.framework.listener.SpringUtilsApplicationPreparedListener;

@ServletComponentScan({"com.jvbo.springboot.practice.module.druid"})//也支持java原生的servlet和filter
@EnableTransactionManagement
@MapperScan({"com.jvbo.springboot.practice.core.dao", "com.jvbo.springboot.practice.core.mapper"})
@SpringBootApplication
public class JvboSpringBootPraticeApplication implements BaseInterface {

    private static Logger logger = LoggerFactory.getLogger(JvboSpringBootPraticeApplication.class);

    @Override
    public void init() {
        logger.info(">>>>> 系统初始化完毕 <<<<<");
    }
    
    @Bean
    public MvcExceptionHandler mvcExceptionHandler() {
        return new MvcExceptionHandler();
    }

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(JvboSpringBootPraticeApplication.class);
        springApplication.addListeners(new BaseServiceInitApplicationReadyListener());
        springApplication.addListeners(new SpringUtilsApplicationPreparedListener());
        springApplication.run(args);
    }
}
