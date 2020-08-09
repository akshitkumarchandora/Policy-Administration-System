package com.cognizant.pas.policy.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.policy.payload.request.UsernamePasswordRequest;



@ExtendWith(MockitoExtension.class)
public class UsernamePasswordRequestTest {

	private UsernamePasswordRequest upr;
	@BeforeEach()
    public void setUp() {
        upr = new UsernamePasswordRequest();
        upr.setUsername("user");
        upr.setPassword("pass");
    }
	
	 @Test
	    public void testAllGettersAndSetters() {
	        assertEquals("user", upr.getUsername());
	        assertEquals("pass",upr.getPassword());
	    }
}
