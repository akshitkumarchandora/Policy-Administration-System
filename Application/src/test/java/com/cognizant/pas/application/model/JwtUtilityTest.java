package com.cognizant.pas.application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtUtilityTest {

    private JwtUtility jwtUtility;

    @BeforeEach
    public void setUp() {
        jwtUtility = new JwtUtility("mock", "mock", "mock", "mock",1,"mock");
    }

    @Test
    public void testAllGetterSetterConstructor() {
        assertEquals("mock",jwtUtility.getSecretKey());
        assertEquals("mock",jwtUtility.getTokenPrefix());
        assertEquals("mock",jwtUtility.getTokenHeader());
        assertEquals("mock",jwtUtility.getClaimsName());
        assertEquals("mock",jwtUtility.getAuthority());
        assertEquals(1,jwtUtility.getTokenExpirationDate());
    }

}
