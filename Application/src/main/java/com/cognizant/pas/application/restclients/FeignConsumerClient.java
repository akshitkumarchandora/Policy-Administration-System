package com.cognizant.pas.application.restclients;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.pas.application.payload.request.BusinessPropertyRequest;
import com.cognizant.pas.application.payload.request.ConsumerBusinessRequest;
import com.cognizant.pas.application.payload.response.BusinessPropertyDetails;
import com.cognizant.pas.application.payload.response.ConsumerBusinessDetails;
import com.cognizant.pas.application.payload.response.MessageResponse;
import com.cognizant.pas.application.payload.response.Property;

import feign.Headers;

@Headers("Content-Type: application/json")
//@FeignClient(name = "emp-ws", url = "${feign.url}")
@FeignClient(name = "consumer-service", url = "${CONSUMER_SERVICE:http://localhost:8133}")
public interface FeignConsumerClient {

	@PostMapping("/consumer-api/createConsumerBusiness")
	public MessageResponse createConsumerBusiness(@RequestHeader("Authorization") String token,
			@RequestBody ConsumerBusinessRequest consumerBusinessRequest);

	@PostMapping("/consumer-api/updateConsumerBusiness")
	public MessageResponse updateConsumerBusiness(@RequestHeader("Authorization") String token,
			@RequestBody ConsumerBusinessDetails consumerBusinessDetails);

	@GetMapping("/consumer-api/viewConsumerBusiness")
	public ConsumerBusinessDetails viewConsumerBusiness(@RequestHeader("Authorization") String token,
			@RequestParam Long consumerid);

	@PostMapping("/consumer-api/createBusinessProperty")
	public MessageResponse createBusinessProperty(@RequestHeader("Authorization") String token,
			@RequestBody BusinessPropertyRequest businessPropertyRequest);

	@PostMapping("/consumer-api/updateBusinessProperty")
	public MessageResponse updateBusinessProperty(@RequestHeader("Authorization") String token,
			@RequestBody BusinessPropertyDetails businessPropertyDetails);

	
	@GetMapping("/consumer-api/viewConsumerProperty")
	public Property viewConsumerProperty(@RequestHeader("Authorization") String token,
			@RequestParam Long consumerid, @RequestParam Long propertyid);


}
