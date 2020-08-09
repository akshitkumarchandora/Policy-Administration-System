package com.cognizant.pas.policy.payload.request;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class UsernamePasswordRequestTest {
	private UsernamePasswordRequest upr;


	@Test
	public void testAllGettersAndSettersOfUsernamePasswordRequest() {
		upr = new UsernamePasswordRequest();
		upr.setUsername("Username");
		upr.setPassword("Password");
		assertEquals("Username",upr.getUsername());
		assertEquals("Password",upr.getPassword());
	}
	
	@Test
	public void testUsernamePasswordRequestConstructor() {
		upr = new UsernamePasswordRequest("Username","Password");
		assertEquals("Username",upr.getUsername());
		assertEquals("Password",upr.getPassword());
	}
}
	

	
