package site.jvbo.fun.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.web.client.RestTemplate;
import site.jvbo.fun.common.redis.serializer.RedisObjectSerializer;
import site.jvbo.fun.common.spring.listener.SpringUtilsApplicationPreparedListener;

@EnableZuulProxy
@EnableEurekaClient
@SpringBootApplication
public class FunZuulApplication {

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory factory) {
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(factory);
		template.setKeySerializer(new StringRedisSerializer());
		template.setValueSerializer(new RedisObjectSerializer());
		return template;
	}

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FunZuulApplication.class);
		springApplication.addListeners(new SpringUtilsApplicationPreparedListener());
		springApplication.run(args);
	}
}
