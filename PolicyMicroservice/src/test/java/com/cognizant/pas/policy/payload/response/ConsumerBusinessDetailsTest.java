package com.cognizant.pas.policy.payload.response;



import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)

class ConsumerBusinessDetailsTest {
	private ConsumerBusinessDetails cbd;


	@Test
	public void testAllGettersAndSettersOfConsumerBusinessDetails() {
		cbd = new ConsumerBusinessDetails();
		cbd.setFirstname("First_Name");
		cbd.setLastname("Last_Name");
		cbd.setDob("DOB");
		cbd.setBusinessname("Business_Name");
		cbd.setPandetails("PANDetails");
		cbd.setEmail("EMAIL");
		cbd.setPhone("Phone");
		cbd.setWebsite("WebSite");
		cbd.setBusinessoverview("BusinessOverview");
		cbd.setValidity("Validity");
		cbd.setAgentname("AgentName");
		cbd.setAgentid((long)1);
		cbd.setBusinessid((long)1);
		cbd.setConsumerId((long)1);
		cbd.setBusinesscategory("BusinessCategory");
		cbd.setBusinesstype("Business_Type");
		cbd.setBusinessturnover((long)1);
		cbd.setCapitalinvested((long)1);
		cbd.setTotalemployees((long)1);
		cbd.setBusinessvalue((long)1);
		cbd.setBusinessage((long)1);
		assertEquals("First_Name",cbd.getFirstname());
		assertEquals("Last_Name",cbd.getLastname());
		assertEquals("DOB",cbd.getDob());
		assertEquals("Business_Name",cbd.getBusinessname());
		assertEquals("PANDetails",cbd.getPandetails());
		assertEquals("EMAIL",cbd.getEmail());
		assertEquals("Phone",cbd.getPhone());
		assertEquals("WebSite",cbd.getWebsite());
		assertEquals("BusinessOverview",cbd.getBusinessoverview());
		assertEquals("Validity",cbd.getValidity());
		assertEquals("AgentName",cbd.getAgentname());
		assertEquals((long)1,cbd.getAgentid());
		assertEquals((long)1,cbd.getBusinessid());
		assertEquals((long)1,cbd.getConsumerId());
		assertEquals("BusinessCategory",cbd.getBusinesscategory());
		assertEquals("Business_Type",cbd.getBusinesstype());
		assertEquals((long)1,cbd.getBusinessturnover());
		assertEquals((long)1,cbd.getCapitalinvested());
		assertEquals((long)1,cbd.getTotalemployees());
		assertEquals((long)1,cbd.getBusinessvalue());
		assertEquals((long)1,cbd.getBusinessage());
	
	}
	
	@Test
	public void testConsumerBusinessDetailsConstructor() {
		cbd = new ConsumerBusinessDetails("test","test","test","test","test","test","test","test","test","test","test",(long)1,(long)1,(long)1,"test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals("test",cbd.getFirstname());
		assertEquals("test",cbd.getLastname());
		assertEquals("test",cbd.getDob());
		assertEquals("test",cbd.getBusinessname());
		assertEquals("test",cbd.getPandetails());
		assertEquals("test",cbd.getEmail());
		assertEquals("test",cbd.getPhone());
		assertEquals("test",cbd.getWebsite());
		assertEquals("test",cbd.getBusinessoverview());
		assertEquals("test",cbd.getValidity());
		assertEquals("test",cbd.getAgentname());
		assertEquals((long)1,cbd.getAgentid());
		assertEquals((long)1,cbd.getBusinessid());
		assertEquals((long)1,cbd.getConsumerId());
		assertEquals("test",cbd.getBusinesscategory());
		assertEquals("test",cbd.getBusinesstype());
		assertEquals((long)1,cbd.getBusinessturnover());
		assertEquals((long)1,cbd.getCapitalinvested());
		assertEquals((long)1,cbd.getTotalemployees());
		assertEquals((long)1,cbd.getBusinessvalue());
		assertEquals((long)1,cbd.getBusinessage());
	
	}

}
