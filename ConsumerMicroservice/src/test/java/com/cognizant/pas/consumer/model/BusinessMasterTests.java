package com.cognizant.pas.consumer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BusinessMasterTests {
	
private BusinessMaster business;
	
	
	@Test
    public void testBusinessMasterDetails() throws Exception {
		business=new BusinessMaster();
		business.setBusinessage((long)10);
		business.setBusinesscategory("category");
		business.setBusinesstype("type");
		business.setId((long)1);
		business.setTotalemployees((long)10);
		assertEquals((long)10,business.getBusinessage());
		assertEquals("category",business.getBusinesscategory());
		assertEquals("type",business.getBusinesstype());
		assertEquals((long)1,business.getId());
		assertEquals((long)10,business.getTotalemployees());
		
	}
	
	@Test
    public void testBusinessMasterConstructor() throws Exception {
		business=new BusinessMaster((long)1,"category","type",(long)1,(long)1);
		assertEquals((long)1,business.getBusinessage());
		assertEquals("category",business.getBusinesscategory());
		assertEquals("type",business.getBusinesstype());
		assertEquals((long)1,business.getId());
		assertEquals((long)1,business.getTotalemployees());
		
	}

}
