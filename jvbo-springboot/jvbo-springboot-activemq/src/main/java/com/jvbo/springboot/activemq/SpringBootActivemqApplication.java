package com.jvbo.springboot.activemq;

import javax.jms.Queue;
import javax.jms.Topic;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

@SpringBootApplication
@EnableJms
public class SpringBootActivemqApplication {
	
	@Autowired
    private ActiveMQConnectionFactory activeMQConnectionFactory;
	
	@Bean
	public Queue queue() {
		return new ActiveMQQueue("sample.queue");
	}
	
	@Bean
    public Topic topic() {
       return new ActiveMQTopic("sample.topic");
    }
	
	@Bean(name = "queueListenerFactory")
    public JmsListenerContainerFactory<?> queueListenerFactory(){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        return bean;
    }

    @Bean(name = "topicListenerFactory")
    public JmsListenerContainerFactory<?> topicListenerFactory(){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(activeMQConnectionFactory);
        bean.setPubSubDomain(true);
        return bean;
    }

	@Bean
	public MessageConverter jacksonJmsMessageConverter() {
	    MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
	    converter.setTargetType(MessageType.TEXT);
	    //converter.setTypeIdPropertyName("_type");
	    return converter;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivemqApplication.class, args);
	}
}
