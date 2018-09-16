package site.jvbo.fun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class FunEurekaApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FunEurekaApplication.class);
		springApplication.run(args);
	}
}
