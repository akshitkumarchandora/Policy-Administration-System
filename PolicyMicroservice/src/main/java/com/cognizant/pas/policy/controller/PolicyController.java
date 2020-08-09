package com.cognizant.pas.policy.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.pas.policy.payload.request.CreatePolicyRequest;
import com.cognizant.pas.policy.payload.request.IssuePolicyRequest;
import com.cognizant.pas.policy.payload.response.MessageResponse;
import com.cognizant.pas.policy.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.policy.payload.response.QuotesDetailsResponse;
import com.cognizant.pas.policy.repository.ConsumerPolicyRepository;
import com.cognizant.pas.policy.repository.PolicyMasterRepository;
import com.cognizant.pas.policy.service.PolicyService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class PolicyController {

	@Autowired
	PolicyService policyService;

	@Autowired
	PolicyMasterRepository policyMasterRepository;
	
	@Autowired
	ConsumerPolicyRepository consumerPolicyRepository;


	@PostMapping("/createPolicy")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public MessageResponse createPolicy(@Valid @RequestBody CreatePolicyRequest createPolicyRequest) {
		log.info("Start createPolicy");
		MessageResponse messageResponse = policyService.createPolicy(createPolicyRequest);
		log.debug("MessageResponse : {}", messageResponse);
		log.info("End createPolicy");
		return (messageResponse);
	}

	@PostMapping("/issuePolicy")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public MessageResponse issuePolicy(@Valid @RequestBody IssuePolicyRequest issuePolicyRequest) {
		log.info("Start issuePolicy");
		if (!consumerPolicyRepository.existsByConsumerid(issuePolicyRequest.getConsumerid())) {
			return (new MessageResponse("Sorry!!, No Consumer Found!!"));
		}
		if (!policyMasterRepository.existsByPid(issuePolicyRequest.getPolicyid())) {
			return (new MessageResponse("Sorry!!, No Policy Found!!"));
		}
		if (!(issuePolicyRequest.getPaymentdetails().equals("Success"))) {
			return (new MessageResponse("Sorry!!, Payment Failed!! Try Again"));
		}
		if (!(issuePolicyRequest.getAcceptancestatus().equals("Accepted"))) {
			return (new MessageResponse("Sorry!!, Accepted Failed !! Try Again"));
		}
		MessageResponse messageResponse = policyService.issuePolicy(issuePolicyRequest);
		log.debug("MessageResponse : {}", messageResponse);
		log.info("End issuePolicy");
		return (messageResponse);
	}

	@GetMapping("/viewPolicy")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public ResponseEntity<?> viewPolicy(@Valid @RequestParam Long consumerid, @RequestParam String policyid) {
		log.info("Start viewPolicy");
		if (!policyMasterRepository.existsByPid(policyid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Policy Found!!"));
		}
		if (!consumerPolicyRepository.existsByConsumerid(consumerid)) {
			return ResponseEntity.badRequest().body(new MessageResponse("Sorry!!, No Consumer Found!!"));
		}	
		PolicyDetailsResponse policyDetailsResponse = policyService.viewPolicy(consumerid, policyid);
		log.debug("PolicyDetailsResponse: {}", policyDetailsResponse);
		log.info("End viewPolicy");
		return ResponseEntity.ok(policyDetailsResponse);
	}

	@GetMapping("/getQuotes")
	@HystrixCommand(fallbackMethod = "sendPolicyErrorResponse")
	public ResponseEntity<QuotesDetailsResponse> getQuotes(@Valid @RequestParam Long businessValue, @RequestParam Long propertyValue,
			@RequestParam String propertyType) {
		log.info("Start getQuotes");
		QuotesDetailsResponse quotesDetailsResponse = policyService.getQuotes(businessValue, propertyValue,
				propertyType);
		log.debug("QuotesMaster: {}", quotesDetailsResponse);
		log.info("End getQuotes");
		return ResponseEntity.ok(quotesDetailsResponse);
	}

	public MessageResponse sendPolicyErrorResponse() {
		return (new MessageResponse("(Policy Error Response!!"));

	}

}
