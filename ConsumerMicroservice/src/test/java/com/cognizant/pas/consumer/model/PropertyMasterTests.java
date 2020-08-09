package com.cognizant.pas.consumer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;



@ExtendWith(MockitoExtension.class)
public class PropertyMasterTests {
	
	private PropertyMaster property;
	
	
	@Test
    public void testPropertyMasterDetails() throws Exception {
		property=new PropertyMaster();
		property.setBuildingage((long)1);
		property.setBuildingtype("type");
		property.setId((long)1);
		property.setInsurancetype("itype");
		property.setPropertytype("ptype");
		assertEquals((long)1,property.getBuildingage());
		assertEquals("type",property.getBuildingtype());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsurancetype());
		assertEquals("ptype",property.getPropertytype());
	}
	
	@Test
    public void testPropertyMasterConstructor() throws Exception {
		property=new PropertyMaster((long)1,"itype","ptype","type",(long)1);
		assertEquals((long)1,property.getBuildingage());
		assertEquals("type",property.getBuildingtype());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsurancetype());
		assertEquals("ptype",property.getPropertytype());
	}

}
