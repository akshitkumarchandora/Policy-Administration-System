package com.cognizant.pas.consumer.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.consumer.payload.request.ConsumerBusinessRequest;


@ExtendWith(MockitoExtension.class)
public class ConsumerBusinessRequestTests {
	
	ConsumerBusinessRequest consumerBusinessRequest;

	
	@Test
    public void testConsumerBusinessRequest() throws Exception {
		consumerBusinessRequest=new ConsumerBusinessRequest();
		consumerBusinessRequest.setAgentid((long)1);
		consumerBusinessRequest.setAgentname("test");
		consumerBusinessRequest.setBusinessage((long)1);
		consumerBusinessRequest.setBusinesscategory("test");
		consumerBusinessRequest.setBusinessname("test");
		consumerBusinessRequest.setBusinessoverview("test");
		consumerBusinessRequest.setBusinessturnover((long)1);
		consumerBusinessRequest.setBusinesstype("test");
		consumerBusinessRequest.setCapitalinvested((long)1);
		consumerBusinessRequest.setDob("test");
		consumerBusinessRequest.setEmail("test");
		consumerBusinessRequest.setFirstname("test");
		consumerBusinessRequest.setLastname("test");
		consumerBusinessRequest.setPandetails("test");
		consumerBusinessRequest.setPhone("test");
		consumerBusinessRequest.setTotalemployees((long)1);
		consumerBusinessRequest.setValidity("test");
		consumerBusinessRequest.setWebsite("test");
		assertEquals((long)1,consumerBusinessRequest.getAgentid());
		assertEquals("test",consumerBusinessRequest.getAgentname());
		assertEquals((long)1,consumerBusinessRequest.getBusinessage());
		assertEquals("test",consumerBusinessRequest.getBusinesscategory());
		assertEquals("test",consumerBusinessRequest.getBusinessname());
		assertEquals("test",consumerBusinessRequest.getBusinessoverview());
		assertEquals((long)1,consumerBusinessRequest.getBusinessturnover());
		assertEquals("test",consumerBusinessRequest.getBusinesstype());
		assertEquals((long)1,consumerBusinessRequest.getCapitalinvested());
		assertEquals("test",consumerBusinessRequest.getDob());
		assertEquals("test",consumerBusinessRequest.getEmail());
		assertEquals("test",consumerBusinessRequest.getFirstname());
		assertEquals("test",consumerBusinessRequest.getLastname());
		assertEquals("test",consumerBusinessRequest.getPandetails());
		assertEquals("test",consumerBusinessRequest.getPhone());
		assertEquals((long)1,consumerBusinessRequest.getTotalemployees());
		assertEquals("test",consumerBusinessRequest.getValidity());
		assertEquals("test",consumerBusinessRequest.getWebsite());
	}
	
	@Test
    public void testConsumerBusinessRequestConstructor() throws Exception {
		consumerBusinessRequest=new ConsumerBusinessRequest("test","test","test","test","test","test","test","test","test","test","test",(long)1,"test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,consumerBusinessRequest.getAgentid());
		assertEquals("test",consumerBusinessRequest.getAgentname());
		assertEquals((long)1,consumerBusinessRequest.getBusinessage());
		assertEquals("test",consumerBusinessRequest.getBusinesscategory());
		assertEquals("test",consumerBusinessRequest.getBusinessname());
		assertEquals("test",consumerBusinessRequest.getBusinessoverview());
		assertEquals((long)1,consumerBusinessRequest.getBusinessturnover());
		assertEquals("test",consumerBusinessRequest.getBusinesstype());
		assertEquals((long)1,consumerBusinessRequest.getCapitalinvested());
		assertEquals("test",consumerBusinessRequest.getDob());
		assertEquals("test",consumerBusinessRequest.getEmail());
		assertEquals("test",consumerBusinessRequest.getFirstname());
		assertEquals("test",consumerBusinessRequest.getLastname());
		assertEquals("test",consumerBusinessRequest.getPandetails());
		assertEquals("test",consumerBusinessRequest.getPhone());
		assertEquals((long)1,consumerBusinessRequest.getTotalemployees());
		assertEquals("test",consumerBusinessRequest.getValidity());
		assertEquals("test",consumerBusinessRequest.getWebsite());
	}

}
