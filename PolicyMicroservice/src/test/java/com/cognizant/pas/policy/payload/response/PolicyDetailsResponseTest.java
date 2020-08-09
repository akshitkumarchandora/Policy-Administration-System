package com.cognizant.pas.policy.payload.response;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

class PolicyDetailsResponseTest {
	private PolicyDetailsResponse pdr;

	
	@Test
	public void testAllGettersAndSettersOfPolicyDetailsResponse() {
		pdr = new PolicyDetailsResponse();
		pdr.setConsumerid((long)1);
		pdr.setPolicyid("Policy_ID");
		pdr.setProperty_value((long)1);
		pdr.setConsumer_type("Consumer_Type");
		pdr.setAssured_sum("Assured_Sum");
		pdr.setTenure("Tenure");
		pdr.setBusiness_value((long)1);
		pdr.setProperty_type("test");
		pdr.setBase_location("Base_Location");
		pdr.setType("Type");
		pdr.setBusinessid((long)1);
		pdr.setPaymentdetails("PaymentDetails");
		pdr.setAcceptancestatus("AcceptanceStatus");
		pdr.setPolicystatus("PolicyStatus");
		pdr.setEffectivedate("EffectiveDate");
		pdr.setCovered_sum("Covered_Sum");
		pdr.setDuration("Duration");
		pdr.setAcceptedquote("AcceptedQuote");
		assertEquals((long)1,pdr.getConsumerid());
		assertEquals("Policy_ID",pdr.getPolicyid());
		assertEquals("test",pdr.getProperty_type());
		assertEquals("Consumer_Type",pdr.getConsumer_type());
		assertEquals("Assured_Sum",pdr.getAssured_sum());
		assertEquals("Tenure",pdr.getTenure());
		assertEquals((long)1,pdr.getBusiness_value());
		assertEquals((long)1,pdr.getProperty_value());
		assertEquals("Base_Location",pdr.getBase_location());
		assertEquals("Type",pdr.getType());
		assertEquals((long)1,pdr.getBusinessid());
		assertEquals("PaymentDetails",pdr.getPaymentdetails());
		assertEquals("AcceptanceStatus",pdr.getAcceptancestatus());
		assertEquals("PolicyStatus",pdr.getPolicystatus());
		assertEquals("EffectiveDate",pdr.getEffectivedate());
		assertEquals("Covered_Sum",pdr.getCovered_sum());
		assertEquals("Duration",pdr.getDuration());
		assertEquals("AcceptedQuote",pdr.getAcceptedquote());	
		
	}
	
	@Test
	public void testPolicyDetailsResponseConstructor() {
		pdr = new PolicyDetailsResponse((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,"test","test","test","test","test","test","test");
		assertEquals((long)1,pdr.getConsumerid());
		assertEquals("test",pdr.getPolicyid());
		assertEquals("test",pdr.getProperty_type());
		assertEquals("test",pdr.getConsumer_type());
		assertEquals("test",pdr.getAssured_sum());
		assertEquals("test",pdr.getTenure());
		assertEquals((long)1,pdr.getBusiness_value());
		assertEquals((long)1,pdr.getProperty_value());
		assertEquals("test",pdr.getBase_location());
		assertEquals("test",pdr.getType());
		assertEquals((long)1,pdr.getBusinessid());
		assertEquals("test",pdr.getPaymentdetails());
		assertEquals("test",pdr.getAcceptancestatus());
		assertEquals("test",pdr.getPolicystatus());
		assertEquals("test",pdr.getEffectivedate());
		assertEquals("test",pdr.getCovered_sum());
		assertEquals("test",pdr.getDuration());
		assertEquals("test",pdr.getAcceptedquote());	
		
	}

}
