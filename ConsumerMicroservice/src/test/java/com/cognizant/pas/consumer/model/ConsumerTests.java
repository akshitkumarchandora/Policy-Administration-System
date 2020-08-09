package com.cognizant.pas.consumer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class ConsumerTests {
	
	private Consumer consumer;
	
	
	@Test
    public void testConsumerDetails() throws Exception {
		consumer =new Consumer();
		consumer.setAgentid((long)1);
		consumer.setAgentname("name");
		consumer.setBusinessname("bname");
		consumer.setBusinessoverview("overview");
		consumer.setDob("dob");
		consumer.setEmail("email");
		consumer.setFirstname("fname");
		consumer.setId((long)1);
		consumer.setLastname("lname");
		consumer.setPandetails("pan");
		consumer.setPhone("phone");
		consumer.setValidity("val");
		consumer.setWebsite("web");
		assertEquals((long)1,consumer.getAgentid());
		assertEquals("name",consumer.getAgentname());
		assertEquals("bname",consumer.getBusinessname());
		assertEquals("overview",consumer.getBusinessoverview());
		assertEquals("dob",consumer.getDob());
		assertEquals("email",consumer.getEmail());
		assertEquals("fname",consumer.getFirstname());
		assertEquals((long)1,consumer.getId());
		assertEquals("lname",consumer.getLastname());
		assertEquals("pan",consumer.getPandetails());
		assertEquals("phone",consumer.getPhone());
		assertEquals("val",consumer.getValidity());
		assertEquals("web",consumer.getWebsite());
	}
	
	@Test
    public void testConsumerAllArgsConstructor() throws Exception {
		consumer =new Consumer((long)1,"test","test","test","test","test","test","test","test","test","test","test",(long)1);
		assertEquals((long)1,consumer.getAgentid());
		assertEquals("test",consumer.getAgentname());
		assertEquals("test",consumer.getBusinessname());
		assertEquals("test",consumer.getBusinessoverview());
		assertEquals("test",consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstname());
		assertEquals((long)1,consumer.getId());
		assertEquals("test",consumer.getLastname());
		assertEquals("test",consumer.getPandetails());
		assertEquals("test",consumer.getPhone());
		assertEquals("test",consumer.getValidity());
		assertEquals("test",consumer.getWebsite());
	}
	@Test
    public void testConsumerArgsConstructor() throws Exception {
		consumer =new Consumer("test","test","test","test","test","test","test","test","test","test","test",(long)1);
		assertEquals("test",consumer.getAgentname());
		assertEquals("test",consumer.getBusinessname());
		assertEquals("test",consumer.getBusinessoverview());
		assertEquals("test",consumer.getDob());
		assertEquals("test",consumer.getEmail());
		assertEquals("test",consumer.getFirstname());
		assertEquals("test",consumer.getLastname());
		assertEquals("test",consumer.getPandetails());
		assertEquals("test",consumer.getPhone());
		assertEquals("test",consumer.getValidity());
		assertEquals("test",consumer.getWebsite());
	}

}
