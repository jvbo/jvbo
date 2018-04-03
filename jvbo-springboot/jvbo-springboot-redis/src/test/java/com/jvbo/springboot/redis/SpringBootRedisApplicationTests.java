package com.jvbo.springboot.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRedisApplicationTests {

	@Autowired
    private ValueOperations<String, Object> valueOperations;

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testStringOps() {
        this.valueOperations.set("k1", "spring-redis");

        Boolean hasKey = this.redisTemplate.hasKey("k1");
        Assert.assertEquals(true, hasKey);

        Object str = this.valueOperations.get("k1");
        Assert.assertNotNull(str);
        Assert.assertEquals("spring-redis", str.toString());
    }

}
