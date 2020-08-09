package com.cognizant.pas.quotes.config;

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
				"Quotes Microservice API",
				"Quotes Microservice will be invoked only from Policy Service. Post authorization of request; based on the business value and property value, for the opted policy quotes will be calculated. The service exposes the following operation: \r\n" + 
				" \r\n" + 
				"Get Quotes – for the given consumer business and property value, policy type, policy covered sum etc. \r\n" + 
				" ",
				"1.0",
				"©Copyright Application",
				new springfox.documentation.service.Contact("Akshit Chandora", "https://akshitchandora.com", "akshitchandora9812@gmail.com"),
				"API License",
				"https://akshitchandora.com",
				Collections.emptyList());
		
	}
}
