/*
 * BlackPhoneMember.java 2018年5月29日
 * Copyright (c) 2015-2018, Jv Bo (programmer_jv_bo@163.com).
 */
package com.jvbo.springboot.testng.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.jvbo.springboot.testng.SpringBootTestngApplication;
import com.jvbo.springboot.testng.sample.TestRestTemplateTest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringBootTestngApplication.class, webEnvironment = WebEnvironment.RANDOM_PORT)
public class BlackPhoneMember {
    
    private static final Logger logger = LoggerFactory.getLogger(TestRestTemplateTest.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    @Before
    public void setUp(){
        
    }
    
    @Test
    public void testSADDmember(){
        stringRedisTemplate.opsForSet().add("heiyushop.app.server.user.blacklist.", "15708440120");
        boolean hasKey = stringRedisTemplate.opsForSet().isMember("heiyushop.app.server.user.blacklist.", "15708440120");
        System.out.println(hasKey);
    }

}
