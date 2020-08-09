package com.cognizant.pas.consumer.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class BusinessTests {
	
	private Business business;
	
    
	@Test
    public void testBusinessDetails() throws Exception {
		business=new Business();
	    business.setBusinessage((long)11);
	    business.setBusinesscategory("category");
	    business.setBusinessturnover((long)10);
	    business.setBusinesstype("type");
	    business.setBusinessvalue((long)500);
	    business.setCapitalinvested((long)200);
	    business.setConsumerId((long)1);
	    business.setId((long)1);
	    business.setTotalemployees((long)10);
        assertEquals((long)11,business.getBusinessage());
        assertEquals("category",business.getBusinesscategory());
        assertEquals((long)10,business.getBusinessturnover() );
        assertEquals("type",business.getBusinesstype() );
        assertEquals((long)500,business.getBusinessvalue() );
        assertEquals((long)200,business.getCapitalinvested() );
        assertEquals((long)1,business.getConsumerId() );
        assertEquals((long)1,business.getId() );
        assertEquals((long)10,business.getTotalemployees());

    }
	
	@Test
    public void testBusinessAllArgsConstructor() throws Exception {
		business=new Business((long)1,(long)1,"category","type",(long)1,(long)1,(long)1,(long)1,(long)1);
        assertEquals((long)1,business.getBusinessage());
        assertEquals("category",business.getBusinesscategory());
        assertEquals((long)1,business.getBusinessturnover() );
        assertEquals("type",business.getBusinesstype() );
        assertEquals((long)1,business.getBusinessvalue() );
        assertEquals((long)1,business.getCapitalinvested() );
        assertEquals((long)1,business.getConsumerId() );
        assertEquals((long)1,business.getId() );
        assertEquals((long)1,business.getTotalemployees());

    }
	@Test
    public void testBusinessArgsController() throws Exception {
		business=new Business((long)1,"category","type",(long)1,(long)1,(long)1,(long)1,(long)1);
        assertEquals((long)1,business.getBusinessage());
        assertEquals("category",business.getBusinesscategory());
        assertEquals((long)1,business.getBusinessturnover() );
        assertEquals("type",business.getBusinesstype() );
        assertEquals((long)1,business.getBusinessvalue() );
        assertEquals((long)1,business.getCapitalinvested() );
        assertEquals((long)1,business.getConsumerId() );
        assertEquals((long)1,business.getTotalemployees());

    }

}
