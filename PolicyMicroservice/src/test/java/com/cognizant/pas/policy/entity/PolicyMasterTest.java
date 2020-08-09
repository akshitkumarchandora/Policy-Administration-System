package com.cognizant.pas.policy.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.policy.models.PolicyMaster;

@ExtendWith(MockitoExtension.class)
class PolicyMasterTest {


	private PolicyMaster pm;
	@BeforeEach()
    public void setUp() {
        pm = new PolicyMaster();
        pm.setId(100L);
        pm.setPid("P01");
        pm.setProperty_type("property_type");
        pm.setAssured_sum("10,000");
        pm.setBase_location("CHD");
        pm.setBusiness_value(1L);
        pm.setConsumer_type("consumer_type");
        pm.setProperty_type("property_type");
        pm.setTenure("tenure");
        pm.setType("type");
              
        
    }
	
	 @Test
	    public void testAllGettersAndSettersOfPolicyMaster() {
	        assertEquals(100L,pm.getId());
	        assertEquals("P01",pm.getPid());
	        assertEquals("property_type",pm.getProperty_type());
	        assertEquals("10,000",pm.getAssured_sum());
	        assertEquals("CHD",pm.getBase_location());
	    }

}


