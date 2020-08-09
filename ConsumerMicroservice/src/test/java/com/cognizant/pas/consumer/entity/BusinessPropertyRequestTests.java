package com.cognizant.pas.consumer.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.consumer.payload.request.BusinessPropertyRequest;


@ExtendWith(MockitoExtension.class)
public class BusinessPropertyRequestTests {
	
	BusinessPropertyRequest businessPropertyRequest;

	
	@Test
    public void testBusinessPropertyRequest() throws Exception {
		businessPropertyRequest=new BusinessPropertyRequest();
		businessPropertyRequest.setBuildingage((long)1);
		businessPropertyRequest.setBuildingsqft("buildingsqft");
		businessPropertyRequest.setBuildingstoreys("buildingstoreys");
		businessPropertyRequest.setBuildingtype("buildingtype");
		businessPropertyRequest.setBusinessId((long)1);
		businessPropertyRequest.setConsumerId((long)1);
		businessPropertyRequest.setCostoftheasset((long)1);
		businessPropertyRequest.setInsurancetype("insurancetype");
		businessPropertyRequest.setPropertytype("propertytype");
		businessPropertyRequest.setSalvagevalue((long)1);
		businessPropertyRequest.setUsefullifeoftheAsset((long)1);
		assertEquals((long)1,businessPropertyRequest.getBuildingage());
		assertEquals("buildingsqft",businessPropertyRequest.getBuildingsqft());
		assertEquals("buildingstoreys",businessPropertyRequest.getBuildingstoreys());
		assertEquals("buildingtype",businessPropertyRequest.getBuildingtype());
		assertEquals((long)1,businessPropertyRequest.getBusinessId());
		assertEquals((long)1,businessPropertyRequest.getConsumerId());
		assertEquals((long)1,businessPropertyRequest.getCostoftheasset());
		assertEquals("insurancetype",businessPropertyRequest.getInsurancetype());
		assertEquals("propertytype",businessPropertyRequest.getPropertytype());
		assertEquals((long)1,businessPropertyRequest.getSalvagevalue());
		assertEquals((long)1,businessPropertyRequest.getUsefullifeoftheAsset());
	}
	
	@Test
    public void testBusinessPropertyRequestConstructor() throws Exception {
		businessPropertyRequest=new BusinessPropertyRequest((long)1,(long)1,"test","test","test","test","test",(long)1,(long)1,(long)1,(long)1);
		assertEquals((long)1,businessPropertyRequest.getBuildingage());
		assertEquals("test",businessPropertyRequest.getBuildingsqft());
		assertEquals("test",businessPropertyRequest.getBuildingstoreys());
		assertEquals("test",businessPropertyRequest.getBuildingtype());
		assertEquals((long)1,businessPropertyRequest.getBusinessId());
		assertEquals((long)1,businessPropertyRequest.getConsumerId());
		assertEquals((long)1,businessPropertyRequest.getCostoftheasset());
		assertEquals("test",businessPropertyRequest.getInsurancetype());
		assertEquals("test",businessPropertyRequest.getPropertytype());
		assertEquals((long)1,businessPropertyRequest.getSalvagevalue());
		assertEquals((long)1,businessPropertyRequest.getUsefullifeoftheAsset());
	}
	

}
