package site.jvbo.fun.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

@SpringCloudApplication
public class FunZuulApplication {
	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FunZuulApplication.class);
		springApplication.run(args);
	}
}
