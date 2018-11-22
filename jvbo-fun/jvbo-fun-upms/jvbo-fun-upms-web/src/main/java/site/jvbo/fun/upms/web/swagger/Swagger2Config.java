package site.jvbo.fun.upms.web.swagger;

import com.github.xiaoymin.swaggerbootstrapui.annotations.EnableSwaggerBootstrapUI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
@EnableSwaggerBootstrapUI // swagger-bootstrap-ui
public class Swagger2Config {

	/**
	 * 1. default springfox-swagger-ui
	 * http://${host}:${port}/swagger-ui.html
	 *
	 * 2. personal swagger-bootstrap-ui
	 * http://${host}:${port}/doc.html
	 */

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.groupName("jvbo-fun-upms-web")
				.apiInfo(apiInfo())
				.select()
				.apis(RequestHandlerSelectors.basePackage("site.jvbo.fun.upms.web.controller"))
				.paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder()
				.title("UPMS Restful API")
				.description("UPMS系统API")
				//.termsOfServiceUrl("http://localhost:8080/")
				.version("0.0.1-SNAPSHOT")
				//.contact(new Contact("jvbo", "http://jvbo.site", "programmer.jv.bo@gmail.com"))
				.build();
	}
}
