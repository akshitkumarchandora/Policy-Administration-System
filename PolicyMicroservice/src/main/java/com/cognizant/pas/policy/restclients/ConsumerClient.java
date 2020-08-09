package com.cognizant.pas.policy.restclients;

import javax.validation.Valid;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.pas.policy.payload.response.ConsumerBusinessDetails;

import feign.Headers;

@Headers("Content-Type: application/json")
//@FeignClient(name = "emp-ws", url = "${feign.url}")
@FeignClient(name = "consumer-service", url = "${CONSUMER_SERVICE:http://localhost:8133}")
public interface ConsumerClient {
	
	@GetMapping("/consumer-api/viewConsumerBusinessByPolicy")
	public ConsumerBusinessDetails viewConsumerBusiness(@Valid @RequestParam Long consumerid);

}
