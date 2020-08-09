package com.cognizant.pas.policy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableFeignClients
@ComponentScan(basePackages={"com.cognizant"})
@EnableJpaRepositories
public class PolicyMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PolicyMicroserviceApplication.class, args);
	}

}
