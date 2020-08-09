package com.cognizant.pas.AuthorizationServer.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.cognizant.pas.AuthorizationServer.model.Authorities;
import com.cognizant.pas.AuthorizationServer.model.Users;
import com.cognizant.pas.AuthorizationServer.repository.UserRepository;
import com.cognizant.pas.AuthorizationServer.service.UserDetailsServiceImpl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserDetailsServiceImplTest {

    @Mock
    private UserRepository userRepository;
    private UserDetailsServiceImpl userDetailsService;
    @Mock
    private Users mockUser;

    @BeforeEach
    public void setUp() {
        Authorities authorities = new Authorities("ROLE_USER");
        mockUser = new Users(1,"mock_user", "mock_password",
                "mock_firstname", "mock_lastname", new HashSet<Authorities>(Arrays.asList(authorities)));
        userDetailsService = new UserDetailsServiceImpl(userRepository);
    }

    @Test
    public void testLoadUserByUsername_authenticatesUser_ifUserExists() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.of(mockUser));
        UserDetails userDetails = userDetailsService.loadUserByUsername(mockUser.getEmail());
        verify(userRepository,atLeast(1)).findByEmail(anyString());
        assertEquals(mockUser.getEmail(), userDetails.getUsername());
    }

    @Test
    public void testLoadUserByUsername_throwsException_whenUserDoesNotExists() {
        when(userRepository.findByEmail(anyString())).thenReturn(Optional.empty());
        assertThrows(UsernameNotFoundException.class, () -> userDetailsService.loadUserByUsername(mockUser.getEmail()));
        verify(userRepository,atLeast(1)).findByEmail(anyString());
    }

}