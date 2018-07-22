package com.jvbo.springboot.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

import com.jvbo.springboot.kafka.example.DemoProducer;

@SpringBootApplication
public class SpringBootKafkaApplication implements CommandLineRunner {
    
    @Autowired
    private DemoProducer demoProducer;
	
	public static void main(String[] args) {
	    SpringApplicationBuilder builder = new SpringApplicationBuilder(SpringBootKafkaApplication.class).web(WebApplicationType.NONE);
	    builder.run(args);
	}

    @Override
    public void run(String... args) throws Exception {
        // TODO Auto-generated method stub
        demoProducer.demoProducer();
    }
}
