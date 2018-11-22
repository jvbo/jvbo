package site.jvbo.fun.okex;

import com.alibaba.fastjson.JSON;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import site.jvbo.fun.common.base.BaseInterface;
import site.jvbo.fun.common.redis.serializer.RedisObjectSerializer;
import site.jvbo.fun.common.spring.listener.BaseServiceInitApplicationReadyListener;
import site.jvbo.fun.common.spring.listener.SpringUtilsApplicationPreparedListener;
import site.jvbo.fun.okex.crawler.task.TaskExecutor;

@MapperScan({"site.jvbo.fun.okex.dao", "site.jvbo.fun.okex.mapper"})
@EnableTransactionManagement
@EnableScheduling
@SpringBootApplication
public class FunOkexCrawlerApplication implements BaseInterface, CommandLineRunner {
	private static Logger logger = LoggerFactory.getLogger(FunOkexCrawlerApplication.class);

	@Autowired
	private TaskExecutor taskExecutor;

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
		SpringApplicationBuilder builder = new SpringApplicationBuilder(FunOkexCrawlerApplication.class).web(false)
				.listeners(new SpringUtilsApplicationPreparedListener(), new BaseServiceInitApplicationReadyListener());
		builder.run(args);
	}

	@Override
	public void run(String... strings) throws Exception {
		Runtime.getRuntime().addShutdownHook(new ShutdownHookRunner(taskExecutor));
		taskExecutor.addTask();
		taskExecutor.execute();
	}

	private class ShutdownHookRunner extends Thread {
		private TaskExecutor taskExecutor;

		public ShutdownHookRunner(TaskExecutor taskExecutor){
			this.taskExecutor = taskExecutor;
		}

		@Override
		public void run() {
			try {
				taskExecutor.join();
			} catch (InterruptedException e) {
				logger.error("异常:{}, 详情:{}", e.getMessage(), JSON.toJSONString(e));
			}
		}
	}
}
