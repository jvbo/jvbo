package site.jvbo.fun.upms;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.client.RestTemplate;
import site.jvbo.fun.common.base.BaseInterface;
import site.jvbo.fun.common.redis.serializer.RedisObjectSerializer;
import site.jvbo.fun.common.spring.listener.BaseServiceInitApplicationReadyListener;
import site.jvbo.fun.common.spring.listener.SpringUtilsApplicationPreparedListener;

@EnableTransactionManagement
@MapperScan({"site.jvbo.fun.upms.dao.dao", "site.jvbo.fun.upms.dao.mapper"})
@SpringCloudApplication
public class FunUpmsWebApplication implements BaseInterface {
	private static Logger logger = LoggerFactory.getLogger(FunUpmsWebApplication.class);

	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Override
	public void init() {
		logger.info(">>>>> 系统初始化完毕 <<<<<");
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
		SpringApplication springApplication = new SpringApplication(FunUpmsWebApplication.class);
		springApplication.addListeners(new SpringUtilsApplicationPreparedListener());
		springApplication.addListeners(new BaseServiceInitApplicationReadyListener());
		springApplication.run(args);
	}
}
