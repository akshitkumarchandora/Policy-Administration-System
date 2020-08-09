package com.cognizant.pas.AuthorizationServer.jwt;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pas.AuthorizationServer.jwt.JwtUtility;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JwtUtilityTest {

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