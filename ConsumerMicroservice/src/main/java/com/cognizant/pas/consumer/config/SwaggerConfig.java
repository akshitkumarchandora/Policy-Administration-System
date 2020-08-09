package com.cognizant.pas.consumer.config;

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
				"Consumer Microservice API",
				"An Agent through Insureity App can interact with Consumer Service to create new consumer / update consumer details. Consumer is the customer here who wishes to subscribe to a Business Property Insurance with the Insurance Company. In this project we are restricting to Property Insurance that means the land/building in which the business is operated will be covered. \r\n" + 
				" \r\n" + 
				"The Consumer Microservice has to interact with Policy Microservice to create a policy and as well as to view the policy status \r\n" + 
				" \r\n" + 
				"Post Authorization, the Consumer Microservice will perform the following functionalities: \r\n" + 
				"->	Create Consumer Business \r\n" + 
				"->	Create Business Property \r\n" + 
				"->	View Consumer Business \r\n" + 
				"->	View Business Property \r\n" + 
				"->	Update Consumer Business \r\n" + 
				"->	Update Business Property  ",
				"1.0",
				"©Copyright Application",
				new springfox.documentation.service.Contact("Akshit Chandora", "https://akshitchandora.com", "akshitchandora9812@gmail.com"),
				"API License",
				"https://akshitchandora.com",
				Collections.emptyList());
		
	}
}
