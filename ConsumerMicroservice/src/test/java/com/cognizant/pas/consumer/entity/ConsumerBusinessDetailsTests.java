package com.cognizant.pas.consumer.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.consumer.payload.response.ConsumerBusinessDetails;


@ExtendWith(MockitoExtension.class)
public class ConsumerBusinessDetailsTests {

	ConsumerBusinessDetails consumerBusinessDetails;
	
	
	@Test
    public void testConsumerBusinessDetails() throws Exception {
		consumerBusinessDetails=new ConsumerBusinessDetails();
		consumerBusinessDetails.setAgentid((long)1);
		consumerBusinessDetails.setAgentname("test");
		consumerBusinessDetails.setBusinessage((long)1);
		consumerBusinessDetails.setBusinesscategory("test");
		consumerBusinessDetails.setBusinessname("test");
		consumerBusinessDetails.setBusinessoverview("test");
		consumerBusinessDetails.setBusinessturnover((long)1);
		consumerBusinessDetails.setBusinesstype("test");
		consumerBusinessDetails.setCapitalinvested((long)1);
		consumerBusinessDetails.setDob("test");
		consumerBusinessDetails.setEmail("test");
		consumerBusinessDetails.setFirstname("test");
		consumerBusinessDetails.setLastname("test");
		consumerBusinessDetails.setPandetails("test");
		consumerBusinessDetails.setPhone("test");
		consumerBusinessDetails.setTotalemployees((long)1);
		consumerBusinessDetails.setValidity("test");
		consumerBusinessDetails.setWebsite("test");
		consumerBusinessDetails.setBusinessid((long)1);
		consumerBusinessDetails.setConsumerId((long)1);
		assertEquals((long)1,consumerBusinessDetails.getAgentid());
		assertEquals("test",consumerBusinessDetails.getAgentname());
		assertEquals((long)1,consumerBusinessDetails.getBusinessage());
		assertEquals("test",consumerBusinessDetails.getBusinesscategory());
		assertEquals("test",consumerBusinessDetails.getBusinessname());
		assertEquals("test",consumerBusinessDetails.getBusinessoverview());
		assertEquals((long)1,consumerBusinessDetails.getBusinessturnover());
		assertEquals("test",consumerBusinessDetails.getBusinesstype());
		assertEquals((long)1,consumerBusinessDetails.getCapitalinvested());
		assertEquals("test",consumerBusinessDetails.getDob());
		assertEquals("test",consumerBusinessDetails.getEmail());
		assertEquals("test",consumerBusinessDetails.getFirstname());
		assertEquals("test",consumerBusinessDetails.getLastname());
		assertEquals("test",consumerBusinessDetails.getPandetails());
		assertEquals("test",consumerBusinessDetails.getPhone());
		assertEquals((long)1,consumerBusinessDetails.getTotalemployees());
		assertEquals("test",consumerBusinessDetails.getValidity());
		assertEquals("test",consumerBusinessDetails.getWebsite());
		assertEquals((long)1,consumerBusinessDetails.getBusinessid());
		assertEquals((long)1,consumerBusinessDetails.getConsumerId());
	}
	
	@Test
    public void testConsumerBusinessDetailsConstructor() throws Exception {
		consumerBusinessDetails=new ConsumerBusinessDetails("test","test","test","test","test","test","test","test","test","test","test",(long)1,(long)1,(long)1,"test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,consumerBusinessDetails.getAgentid());
		assertEquals("test",consumerBusinessDetails.getAgentname());
		assertEquals((long)1,consumerBusinessDetails.getBusinessage());
		assertEquals("test",consumerBusinessDetails.getBusinesscategory());
		assertEquals("test",consumerBusinessDetails.getBusinessname());
		assertEquals("test",consumerBusinessDetails.getBusinessoverview());
		assertEquals((long)1,consumerBusinessDetails.getBusinessturnover());
		assertEquals("test",consumerBusinessDetails.getBusinesstype());
		assertEquals((long)1,consumerBusinessDetails.getCapitalinvested());
		assertEquals("test",consumerBusinessDetails.getDob());
		assertEquals("test",consumerBusinessDetails.getEmail());
		assertEquals("test",consumerBusinessDetails.getFirstname());
		assertEquals("test",consumerBusinessDetails.getLastname());
		assertEquals("test",consumerBusinessDetails.getPandetails());
		assertEquals("test",consumerBusinessDetails.getPhone());
		assertEquals((long)1,consumerBusinessDetails.getTotalemployees());
		assertEquals("test",consumerBusinessDetails.getValidity());
		assertEquals("test",consumerBusinessDetails.getWebsite());
		assertEquals((long)1,consumerBusinessDetails.getBusinessid());
		assertEquals((long)1,consumerBusinessDetails.getConsumerId());
	}
}
