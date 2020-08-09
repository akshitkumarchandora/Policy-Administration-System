package com.cognizant.pas.policy.service;

import org.springframework.stereotype.Service;

import com.cognizant.pas.policy.payload.request.CreatePolicyRequest;
import com.cognizant.pas.policy.payload.request.IssuePolicyRequest;
import com.cognizant.pas.policy.payload.response.ConsumerBusinessDetails;
import com.cognizant.pas.policy.payload.response.MessageResponse;
import com.cognizant.pas.policy.payload.response.PolicyDetailsResponse;
import com.cognizant.pas.policy.payload.response.QuotesDetailsResponse;

@Service
public interface PolicyService {

	QuotesDetailsResponse getQuotes(Long businessValue, Long propertyValue, String propertyType);

	PolicyDetailsResponse viewPolicy(Long consumerid, String policyid);

	MessageResponse issuePolicy(IssuePolicyRequest issuePolicyRequest);

	MessageResponse createPolicy(CreatePolicyRequest createPolicyRequest);
	
	ConsumerBusinessDetails getConsumerBusiness(Long consumerid);
	
}
