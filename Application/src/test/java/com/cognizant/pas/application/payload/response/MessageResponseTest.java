//junit of class MessageResponse

package com.cognizant.pas.application.payload.response;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class MessageResponseTest {


	private MessageResponse mr;
	private MessageResponse mrp;
	@BeforeEach()
    public void setUp() {
		mr=new MessageResponse();
		mr.setMessage("msg");
		mrp=new MessageResponse("demo");
	}
	


	@Test
	 public void testAllArgsConstructorOfPolicyDetail() {
		 assertEquals("demo",mrp.getMessage());
	        
	}
	
	 @Test
	    public void testAllGettersAndSettersOfMessageResponse() {
	       
	        assertEquals("msg",mr.getMessage());
	        
	    }

}




