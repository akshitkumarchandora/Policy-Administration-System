//junit of class BusinessPropertyDetails
package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


import com.jparams.verifier.tostring.ToStringVerifier;
@ExtendWith(MockitoExtension.class)
class BusinessPropertyDetailsTest {



	BusinessPropertyDetails businessPropertyDetails;
	private BusinessPropertyDetails bdcon;
	@BeforeEach()
    public void setUp() {
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
		bdcon=new
		BusinessPropertyDetails(1L,1L,1L,"demo","demo","demo","demo","demo",1L,1L,1L,1L);
	}
	@Test
	 public void testArgsConstructorOfBusinessProperty() {
        assertEquals("demo",bdcon.getBuildingsqft());
        assertEquals("demo",bdcon.getBuildingstoreys());
        assertEquals("demo",bdcon.getBuildingtype());
	    assertEquals("demo",bdcon.getInsurancetype());
        assertEquals("demo",bdcon.getPropertytype());
        assertEquals(1L,bdcon.getBuildingage());
        assertEquals(1L,bdcon.getBusinessId());
        assertEquals(1L,bdcon.getConsumerId());
        assertEquals(1L,bdcon.getCostoftheasset());
        assertEquals(1L,bdcon.getPropertyId());
        
	}
	@Test
	 public void testtoStringOfBusinessProperty() {
		ToStringVerifier.forClass(BusinessPropertyDetails.class).verify();
	}
	
	 @Test
	    public void testAllGettersAndSettersOfBusinessProperty() {
	       
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

}

