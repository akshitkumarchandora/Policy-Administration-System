package com.cognizant.pas.consumer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class PropertyTests {
	
	private Property property;
	
	
	@Test
    public void testPropertyDetails() throws Exception {
		property=new Property();
		property.setBuildingage((long)1);
		property.setBuildingsqft("sqft");
		property.setBuildingstoreys("storeys");
		property.setBuildingtype("type");
		property.setBusinessId((long)1);
		property.setConsumerId((long)1);
		property.setCostoftheasset((long)10);
		property.setId((long)1);
		property.setInsurancetype("itype");
		property.setPropertytype("ptype");
		property.setPropertyvalue((long)100);
		property.setSalvagevalue((long)10);
		property.setUsefullifeoftheAsset((long)5);
		assertEquals((long)1,property.getBuildingage());
		assertEquals("sqft",property.getBuildingsqft());
		assertEquals("storeys",property.getBuildingstoreys());
		assertEquals("type",property.getBuildingtype());
		assertEquals((long)1,property.getBusinessId());
		assertEquals((long)1,property.getConsumerId());
		assertEquals((long)10,property.getCostoftheasset());
		assertEquals((long)1,property.getId());
		assertEquals("itype",property.getInsurancetype());
		assertEquals("ptype",property.getPropertytype());
		assertEquals((long)100,property.getPropertyvalue());
		assertEquals((long)10,property.getSalvagevalue());
		assertEquals((long)5,property.getUsefullifeoftheAsset());
	}
	
	@Test
    public void testPropertyAllArgsConstructor() throws Exception {
		property=new Property((long)1,(long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,property.getBuildingage());
		assertEquals("test",property.getBuildingsqft());
		assertEquals("test",property.getBuildingstoreys());
		assertEquals("test",property.getBuildingtype());
		assertEquals((long)1,property.getBusinessId());
		assertEquals((long)1,property.getConsumerId());
		assertEquals((long)1,property.getCostoftheasset());
		assertEquals((long)1,property.getId());
		assertEquals("test",property.getInsurancetype());
		assertEquals("test",property.getPropertytype());
		assertEquals((long)1,property.getPropertyvalue());
		assertEquals((long)1,property.getSalvagevalue());
		assertEquals((long)1,property.getUsefullifeoftheAsset());
	}
	@Test
    public void testPropertyArgsConstructor() throws Exception {
		property=new Property((long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,property.getBuildingage());
		assertEquals("test",property.getBuildingsqft());
		assertEquals("test",property.getBuildingstoreys());
		assertEquals("test",property.getBuildingtype());
		assertEquals((long)1,property.getBusinessId());
		assertEquals((long)1,property.getConsumerId());
		assertEquals((long)1,property.getCostoftheasset());
		assertEquals("test",property.getInsurancetype());
		assertEquals("test",property.getPropertytype());
		assertEquals((long)1,property.getPropertyvalue());
		assertEquals((long)1,property.getSalvagevalue());
		assertEquals((long)1,property.getUsefullifeoftheAsset());
	}

}
