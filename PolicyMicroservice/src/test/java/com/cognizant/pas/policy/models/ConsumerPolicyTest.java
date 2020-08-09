package com.cognizant.pas.policy.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class ConsumerPolicyTest {


private ConsumerPolicy consumerPolicy;
	
	
	@Test
    public void testConsumerPolicy() throws Exception {
		consumerPolicy= new ConsumerPolicy();
		consumerPolicy.setAcceptancestatus("acceptancestatus");
		consumerPolicy.setAcceptedquote("acceptedquote");
		consumerPolicy.setBusinessid((long)1);
		consumerPolicy.setConsumerid((long)1);
		consumerPolicy.setCovered_sum("covered_sum");
		consumerPolicy.setDuration("duration");
		consumerPolicy.setEffectivedate("effectivedate");
		consumerPolicy.setId((long)1);
		consumerPolicy.setPaymentdetails("paymentdetails");
		consumerPolicy.setPolicyid("policyid");
		consumerPolicy.setPolicystatus("policystatus");
		assertEquals("acceptancestatus",consumerPolicy.getAcceptancestatus());
		assertEquals("acceptedquote",consumerPolicy.getAcceptedquote());
		assertEquals((long)1,consumerPolicy.getBusinessid());
		assertEquals((long)1,consumerPolicy.getConsumerid());
		assertEquals("covered_sum",consumerPolicy.getCovered_sum());
		assertEquals("duration",consumerPolicy.getDuration());
		assertEquals("effectivedate",consumerPolicy.getEffectivedate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("paymentdetails",consumerPolicy.getPaymentdetails());
		assertEquals("policyid",consumerPolicy.getPolicyid());
		assertEquals("policystatus",consumerPolicy.getPolicystatus());	
	}
	
	@Test
    public void testConsumerPolicyAllConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,(long)1,"test",(long)1,"test","test","test","test","test","test","test");
		assertEquals("test",consumerPolicy.getAcceptancestatus());
		assertEquals("test",consumerPolicy.getAcceptedquote());
		assertEquals((long)1,consumerPolicy.getBusinessid());
		assertEquals((long)1,consumerPolicy.getConsumerid());
		assertEquals("test",consumerPolicy.getCovered_sum());
		assertEquals("test",consumerPolicy.getDuration());
		assertEquals("test",consumerPolicy.getEffectivedate());
		assertEquals((long)1,consumerPolicy.getId());
		assertEquals("test",consumerPolicy.getPaymentdetails());
		assertEquals("test",consumerPolicy.getPolicyid());
		assertEquals("test",consumerPolicy.getPolicystatus());	
	}

	
	@Test
    public void testConsumerPolicyConstructor() throws Exception {
		consumerPolicy= new ConsumerPolicy((long)1,(long)1,"test","test");
		assertEquals("test",consumerPolicy.getAcceptedquote());
		assertEquals((long)1,consumerPolicy.getBusinessid());
		assertEquals((long)1,consumerPolicy.getConsumerid());
		assertEquals("test",consumerPolicy.getPolicystatus());	
	}

}