package com.cognizant.pas.consumer.jwt;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class JwtUtilityTests {
	
	 private JwtUtility jwtUtility;

	    @BeforeEach
	    public void setUp() {
	        jwtUtility = new JwtUtility("mock_secret", "mock_tokenPrefix",
	                "mock_tokenHeader", "mock_claimName",1,
	                "mock_authority");

	    }
	    
	    @Test
	    public void testJwtUtility() {
	        assertEquals("mock_secret", jwtUtility.getSecretKey());
	        assertEquals("mock_tokenPrefix", jwtUtility.getTokenPrefix());
	        assertEquals("mock_tokenHeader", jwtUtility.getTokenHeader());
	        assertEquals("mock_claimName", jwtUtility.getClaimsName());
	        assertEquals(1, jwtUtility.getTokenExpirationDate());
	        assertEquals("mock_authority", jwtUtility.getAuthority());
	    }
}
