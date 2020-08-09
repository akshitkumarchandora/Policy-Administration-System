package com.cognizant.pas.AuthorizationServer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pas.AuthorizationServer.model.Authorities;
import com.cognizant.pas.AuthorizationServer.model.UserDetailsImpl;
import com.cognizant.pas.AuthorizationServer.model.Users;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(MockitoExtension.class)
class UserDetailsImplTest {

    private UserDetailsImpl userDetails;

    @BeforeEach
    public void setUp() {
        Authorities authorities = new Authorities("ROLE_MOCK");
        Users users = new Users(1,"mock_email", "mock_password",
                "mock_firstname", "mock_lastname",
                new HashSet<>(Arrays.asList(authorities)));
        userDetails = new UserDetailsImpl(users);
    }

    @Test
    public void testGettersSetters() {
        assertEquals("mock_email", userDetails.getUsername());
        assertEquals("mock_password", userDetails.getPassword());
        assertEquals("ROLE_MOCK", userDetails.getAuthorities().stream().findFirst().get().getAuthority());
        assertTrue(userDetails.isAccountNonExpired());
        assertTrue(userDetails.isAccountNonLocked());
        assertTrue(userDetails.isCredentialsNonExpired());
        assertTrue(userDetails.isEnabled());
    }
}