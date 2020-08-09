//junit of class Property


package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.jparams.verifier.tostring.ToStringVerifier;

@ExtendWith(MockitoExtension.class)
class PropertyTest {


	private Property pr;
	private Property property;
	private Property property1;
	@BeforeEach()
    public void setUp() {
		pr=new Property();
		pr.setBuildingage(1L);
		pr.setBuildingsqft("buildingsqft");
		pr.setBuildingstoreys("buildingstoreys");
		pr.setBuildingtype("buildingtype");
		pr.setBusinessId(2L);
		pr.setConsumerId(3L);
		pr.setCostoftheasset(4L);
		pr.setId(5L);
		pr.setInsurancetype("insurancetype");
		pr.setPropertytype("propertytype");
		pr.setPropertyvalue(6L);
		pr.setSalvagevalue(7L);
		property=new Property(1L,2L,3L,"demo","demo","demo","demo","demo",1L,2L,3L,4L,5L);
		property1=new Property(1L,1L,"demo","demo","demo","demo","demo",1L,1L,1L,1L,1L);
	}
	
	@Test
	 public void testAllArgsConstructorOfProperty() {
		assertEquals("demo",property.getBuildingsqft());
	}
	@Test
	 public void testArgsConstructorOfProperty() {
        assertEquals("demo",property1.getBuildingsqft());
        assertEquals("demo",property1.getBuildingstoreys());
        assertEquals("demo",property1.getBuildingtype());
        assertEquals("demo",property1.getInsurancetype());
        assertEquals("demo",property1.getPropertytype());
        assertEquals(1L,property1.getBuildingage());
        assertEquals(1L,property1.getBusinessId());
        assertEquals(1L,property1.getConsumerId());
        assertEquals(1L,property1.getCostoftheasset());
        assertEquals(1L,property1.getPropertyvalue());
        assertEquals(1L,property1.getSalvagevalue());
       
	}
	@Test
	 public void testToStringOfProperty() {
		ToStringVerifier.forClass(Property.class).verify();
	}
	
	 @Test
	    public void testAllGettersAndSettersOfProperty() {
	       
	        assertEquals("buildingsqft",pr.getBuildingsqft());
	        assertEquals("buildingstoreys",pr.getBuildingstoreys());
	        assertEquals("buildingtype",pr.getBuildingtype());
	        assertEquals("insurancetype",pr.getInsurancetype());
	        assertEquals("propertytype",pr.getPropertytype());
	        assertEquals(1L,pr.getBuildingage());
	        assertEquals(2L,pr.getBusinessId());
	        assertEquals(3L,pr.getConsumerId());
	        assertEquals(4L,pr.getCostoftheasset());
	        assertEquals(5L,pr.getId());
	        assertEquals(6L,pr.getPropertyvalue());
	        assertEquals(7L,pr.getSalvagevalue());
	        
	    }

}
