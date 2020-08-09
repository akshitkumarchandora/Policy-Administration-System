package com.cognizant.pas.application.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UsernamePasswordRequestTest {

    private UsernamePasswordRequest usernamePasswordRequest;

    @BeforeEach
    public void setUp() {
        usernamePasswordRequest = new UsernamePasswordRequest();
        usernamePasswordRequest.setUsername("mock_username");
        usernamePasswordRequest.setPassword("mock_password");
    }

    @Test
    public void testGettersSetters() {
        assertEquals("mock_username", usernamePasswordRequest.getUsername());
        assertEquals("mock_password", usernamePasswordRequest.getPassword());
    }
}
