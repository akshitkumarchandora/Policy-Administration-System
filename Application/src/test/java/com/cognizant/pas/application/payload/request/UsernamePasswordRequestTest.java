// junit of class UsernamePasswordRequest
package com.cognizant.pas.application.payload.request;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
public class UsernamePasswordRequestTest {

	private UsernamePasswordRequest upr;
	private UsernamePasswordRequest uprcon;
	@BeforeEach()
    public void setUp() {
        upr = new UsernamePasswordRequest();
        upr.setUsername("user");
        upr.setPassword("pass");
        uprcon=new UsernamePasswordRequest("user","pass");
    }
	
	 @Test
	    public void testAllGettersAndSettersOfUsernamePasswordRequest() {
	        assertEquals("user", upr.getUsername());
	        assertEquals("pass",upr.getPassword());
	    }
	 @Test
	    public void testAllArgsConstructorofUsernamePasswordRequest() {
	        assertEquals("user", uprcon.getUsername());
	        assertEquals("pass",uprcon.getPassword());
	    }
}
