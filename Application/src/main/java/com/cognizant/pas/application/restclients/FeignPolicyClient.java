package com.cognizant.pas.application.restclients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.cognizant.pas.application.payload.request.CreatePolicyRequest;
import com.cognizant.pas.application.payload.request.IssuePolicyRequest;
import com.cognizant.pas.application.payload.response.MessageResponse;
import com.cognizant.pas.application.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.application.payload.response.QuotesDetailsResponse;

import feign.Headers;

@Headers("Content-Type: application/json")
//@FeignClient(name = "emp-ws", url = "${feign.url}")
@FeignClient(name = "policy-service", url = "${POLICY_SERVICE:http://localhost:8333}")
public interface FeignPolicyClient {
	
	@PostMapping("/policy-api/createPolicy")
	public MessageResponse createPolicy(@RequestHeader("Authorization") String token, @RequestBody CreatePolicyRequest createPolicyRequest);
	
	@PostMapping("/policy-api/issuePolicy")
	public MessageResponse issuePolicy(@RequestHeader("Authorization") String token, @RequestBody IssuePolicyRequest issuePolicyRequest);

	@GetMapping("/policy-api/viewPolicy")
	public PolicyDetailsResponse viewPolicy(@RequestHeader("Authorization") String token, @RequestParam Long consumerid, @RequestParam String policyid) ;

	@GetMapping("/policy-api/getQuotes")
	public QuotesDetailsResponse getQuotes(@RequestHeader("Authorization") String token, @RequestParam Long businessValue, @RequestParam Long propertyValue,
			@RequestParam String propertyType);



}
