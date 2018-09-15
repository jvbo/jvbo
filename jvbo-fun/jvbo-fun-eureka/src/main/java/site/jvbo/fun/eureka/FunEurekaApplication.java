package site.jvbo.fun.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class FunEurekaApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FunEurekaApplication.class);
		springApplication.run(args);
	}
}
