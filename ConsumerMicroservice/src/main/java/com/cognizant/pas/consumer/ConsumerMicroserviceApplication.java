package com.cognizant.pas.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@Configuration
@EnableFeignClients
public class ConsumerMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsumerMicroserviceApplication.class, args);
	}

}
