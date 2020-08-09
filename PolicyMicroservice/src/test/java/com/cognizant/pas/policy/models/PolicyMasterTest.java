package com.cognizant.pas.policy.models;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
class PolicyMasterTest {


	private PolicyMaster pm;

	
	 	@Test
	    public void testAllGettersAndSettersOfPolicyMaster() {
		 pm = new PolicyMaster();
	        pm.setId((long)100);
	        pm.setPid("P01");
	        pm.setProperty_type("property_type");
	        pm.setAssured_sum("10,000");
	        pm.setBase_location("CHD");
	        pm.setBusiness_value(1L);
	        pm.setConsumer_type("consumer_type");
	        pm.setProperty_type("property_type");
	        pm.setTenure("tenure");
	        pm.setType("type");
	        assertEquals(100,pm.getId());
	        assertEquals("P01",pm.getPid());
	        assertEquals("property_type",pm.getProperty_type());
	        assertEquals("10,000",pm.getAssured_sum());
	        assertEquals("CHD",pm.getBase_location());
	        assertEquals(1L,pm.getBusiness_value());
	        assertEquals("consumer_type",pm.getConsumer_type());
	        assertEquals("property_type",pm.getProperty_type());
	        assertEquals("tenure",pm.getTenure());
	        assertEquals("type",pm.getType());
	    }
	 	
	 	@Test
	    public void testPolicyMasterConstructor() {
		 pm = new PolicyMaster((long)1,"test","test","test","test","test",(long)1,(long)1,"test","test");
	        assertEquals((long)1,pm.getId());
	        assertEquals("test",pm.getPid());
	        assertEquals("test",pm.getProperty_type());
	        assertEquals("test",pm.getAssured_sum());
	        assertEquals("test",pm.getBase_location());
	        assertEquals((long)1,pm.getBusiness_value());
	        assertEquals("test",pm.getConsumer_type());
	        assertEquals((long)1,pm.getProperty_value());
	        assertEquals("test",pm.getTenure());
	        assertEquals("test",pm.getType());
	    }

}