package com.jvbo.springboot.activemq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.jvbo.springboot.activemq.example.Producer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootRabbitmqApplicationTests {
    
    @Autowired
    private Producer producer;

    @Test
    public void hello() throws Exception {
        producer.send();
    }
    
	@Test
	public void contextLoads() {
	}

}
