package site.jvbo.fun.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringCloudApplication
public class FunGatewayApplication {

	public static void main(String[] args) {
		SpringApplication springApplication = new SpringApplication(FunGatewayApplication.class);
		springApplication.run(args);
	}
}
