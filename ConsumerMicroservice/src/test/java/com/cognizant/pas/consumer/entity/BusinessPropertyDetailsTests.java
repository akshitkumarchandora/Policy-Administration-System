package com.cognizant.pas.consumer.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.consumer.payload.response.BusinessPropertyDetails;


@ExtendWith(MockitoExtension.class)
public class BusinessPropertyDetailsTests {
	
	BusinessPropertyDetails businessPropertyDetails;
	
	
	@Test
    public void testBusinessPropertyDetails() throws Exception {
		businessPropertyDetails=new BusinessPropertyDetails();
		businessPropertyDetails.setBuildingage((long)1);
		businessPropertyDetails.setBuildingsqft("buildingsqft");
		businessPropertyDetails.setBuildingstoreys("buildingstoreys");
		businessPropertyDetails.setBuildingtype("buildingtype");
		businessPropertyDetails.setBusinessId((long)1);
		businessPropertyDetails.setConsumerId((long)1);
		businessPropertyDetails.setCostoftheasset((long)1);
		businessPropertyDetails.setInsurancetype("insurancetype");
		businessPropertyDetails.setPropertyId((long)1);
		businessPropertyDetails.setPropertytype("propertytype");
		businessPropertyDetails.setSalvagevalue((long)1);
		businessPropertyDetails.setUsefullifeoftheAsset((long)1);
		assertEquals((long)1,businessPropertyDetails.getBuildingage());
		assertEquals("buildingsqft",businessPropertyDetails.getBuildingsqft());
		assertEquals("buildingstoreys",businessPropertyDetails.getBuildingstoreys());
		assertEquals("buildingtype",businessPropertyDetails.getBuildingtype());
		assertEquals((long)1,businessPropertyDetails.getBusinessId());
		assertEquals((long)1,businessPropertyDetails.getConsumerId());
		assertEquals((long)1,businessPropertyDetails.getCostoftheasset());
		assertEquals("insurancetype",businessPropertyDetails.getInsurancetype());
		assertEquals((long)1,businessPropertyDetails.getPropertyId());
		assertEquals("propertytype",businessPropertyDetails.getPropertytype());
		assertEquals((long)1,businessPropertyDetails.getSalvagevalue());
		assertEquals((long)1,businessPropertyDetails.getUsefullifeoftheAsset());
	}
	
	@Test
    public void testBusinessPropertyDetailsConstructor() throws Exception {
		businessPropertyDetails=new BusinessPropertyDetails((long)1,(long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,businessPropertyDetails.getBuildingage());
		assertEquals("test",businessPropertyDetails.getBuildingsqft());
		assertEquals("test",businessPropertyDetails.getBuildingstoreys());
		assertEquals("test",businessPropertyDetails.getBuildingtype());
		assertEquals((long)1,businessPropertyDetails.getBusinessId());
		assertEquals((long)1,businessPropertyDetails.getConsumerId());
		assertEquals((long)1,businessPropertyDetails.getCostoftheasset());
		assertEquals("test",businessPropertyDetails.getInsurancetype());
		assertEquals((long)1,businessPropertyDetails.getPropertyId());
		assertEquals("test",businessPropertyDetails.getPropertytype());
		assertEquals((long)1,businessPropertyDetails.getSalvagevalue());
		assertEquals((long)1,businessPropertyDetails.getUsefullifeoftheAsset());
	}

}
