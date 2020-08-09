// junit of  class PolicyDetailsResponse

package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jparams.verifier.tostring.ToStringVerifier;

@ExtendWith(MockitoExtension.class)
class PolicyDetailsResponseTest {

	private PolicyDetailsResponse pdr;
	private PolicyDetailsResponse pdr1;
	@BeforeEach()
	public void setUp() {
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
		pdr1 = new PolicyDetailsResponse((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test",(long)1,"test","test","test","test","test","test","test");
		
	
	}

	@Test
	public void testtoStringOfPolicyDetails() {
		ToStringVerifier.forClass(PolicyDetailsResponse.class).verify();
	}
	
	@Test
	public void testAllArgsConstructorOfPolicyDetails() {
		assertEquals("test", pdr1.getAcceptancestatus());
		
	}

	@Test
	public void testAllGettersAndSettersOfPolicyDetails() {

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

}
