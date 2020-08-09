package com.cognizant.pas.policy.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class IssuePolicyRequestTest {
	private IssuePolicyRequest ipr;

	@Test
	 public void testAllGettersAndSettersOfIssuePolicyRequest() {
		ipr = new IssuePolicyRequest();
		ipr.setPolicyid("Policy_ID");
		ipr.setConsumerid((long)1);
		ipr.setBusinessid((long)1);
		ipr.setPaymentdetails("Payment_Details");
		ipr.setAcceptancestatus("Acceptance_Status");
		assertEquals("Policy_ID",ipr.getPolicyid());
		assertEquals((long)1,ipr.getConsumerid());
		assertEquals((long)1,ipr.getBusinessid());
		assertEquals("Payment_Details",ipr.getPaymentdetails());
		assertEquals("Acceptance_Status",ipr.getAcceptancestatus());
	}
	
	@Test
	 public void testIssuePolicyRequestConstructor() {
		ipr = new IssuePolicyRequest("test",(long)1,(long)1,"test","test");
		assertEquals("test",ipr.getPolicyid());
		assertEquals((long)1,ipr.getConsumerid());
		assertEquals((long)1,ipr.getBusinessid());
		assertEquals("test",ipr.getPaymentdetails());
		assertEquals("test",ipr.getAcceptancestatus());
	}
}

