package com.jvbo.springboot.redis;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {
    
    private static final Logger logger = LoggerFactory.getLogger(SpringBootRedisApplicationTests.class);

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        // TODO 向redis插入数据
        String key = "aaaa";
        stringRedisTemplate.opsForValue().set(key, "1111", 30, TimeUnit.DAYS);
        String data = stringRedisTemplate.opsForValue().get(key);
        logger.info("data:{}", data);
    }

}
