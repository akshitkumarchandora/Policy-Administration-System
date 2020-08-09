package com.cognizant.pas.AuthorizationServer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cognizant.pas.AuthorizationServer.model.Users;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class UsersTest {

    private Users users;

    @BeforeEach()
    public void setUp() {
        users = new Users();
        users.setId(1);
        users.setEmail("mock_email");
        users.setPassword("mock_password");
        users.setFirstname("mock_firstname");
        users.setLastname("mock_lastname");
        users.setAuthorities(null);
    }

    @Test
    public void testAllGettersAndSetters() {
        assertEquals(1, users.getId());
        assertEquals("mock_email",users.getEmail());
        assertEquals("mock_password", users.getPassword());
        assertEquals("mock_firstname", users.getFirstname());
        assertEquals("mock_lastname", users.getLastname());
        assertEquals(null, users.getAuthorities());
    }
}