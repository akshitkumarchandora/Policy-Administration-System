package com.cognizant.pas.AuthorizationServer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pas.AuthorizationServer.model.UsernamePasswordRequest;

import static org.junit.jupiter.api.Assertions.*;

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