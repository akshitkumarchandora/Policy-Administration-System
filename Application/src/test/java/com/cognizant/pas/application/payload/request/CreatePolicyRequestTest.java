//junit of class CreatePolicyRequest
package com.cognizant.pas.application.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class CreatePolicyRequestTest {


	private CreatePolicyRequest cpr;

	@Test
	 public void testAllGettersAndSettersOfCreatePolicyRequest() {
		cpr = new CreatePolicyRequest();
		cpr.setConsumerid((long)1);
		cpr.setAcceptedquotes("Accepted_Quotes");
		assertEquals(1,cpr.getConsumerid());
		assertEquals("Accepted_Quotes",cpr.getAcceptedquotes());
	}
	
	@Test
	 public void testCreatePolicyRequestConstructor() {
		cpr = new CreatePolicyRequest((long)1,"Accepted_Quotes");
		assertEquals(1,cpr.getConsumerid());
		assertEquals("Accepted_Quotes",cpr.getAcceptedquotes());
	}

}
