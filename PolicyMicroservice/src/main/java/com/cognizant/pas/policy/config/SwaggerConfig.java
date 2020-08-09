package com.cognizant.pas.policy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration	
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cognizant"))
				.paths(PathSelectors.any())
				.build()
				.apiInfo(apiDeatils());
	}
	
	private ApiInfo apiDeatils()
	{
		return new ApiInfo(
				"Policy Microservice API",
				"Policy Microservice interacts with Consumer Microservice and Quotes Microservice, but it gets invoked from Insureity Portal (MVC app). Post authorization of request, Policy Microservice allows the following operations: \r\n" + 
				" \r\n" + 
				"•	Creates Policy based on Business and Property Value from Consumer Service. For these values, the service will validate the permissible Policies of type “Property Insurance” and for the coverage the Agent has quoted, and get the quotes from Quotes service.  \r\n" + 
				"•	Issue Policy will issue a policy to the consumer based on the payment and acceptance status from consumer, for the quoted insurance cover. \r\n" + 
				"•	View Policy allows to view the Policy Details ",
				"1.0",
				"©Copyright Application",
				new springfox.documentation.service.Contact("Akshit Chandora", "https://akshitchandora.com", "akshitchandora9812@gmail.com"),
				"API License",
				"https://akshitchandora.com",
				Collections.emptyList());
		
	}
}
