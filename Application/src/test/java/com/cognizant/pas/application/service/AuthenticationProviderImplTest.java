package com.cognizant.pas.application.service;

import feign.FeignException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;

import com.cognizant.pas.application.model.JwtUtility;
import com.cognizant.pas.application.restclients.FeignAuthorizationServer;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthenticationProviderImplTest {

   @MockBean
   private FeignAuthorizationServer feignAuthorizationServer;
   @MockBean
   private Authentication authentication;
   @Mock
   private HttpSession session;
   @Autowired
   private JwtUtility jwtUtility;
   private String tokenString = "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtb2NrX3VzZXIiLCJhdXRob3JpdGllcyI6W3siYXV0aG9yaXR5IjoiUk9MRV9BRE1JTiJ9XSwiaWF0IjoxNTk2Nzg2MTIwLCJleHAiOjE2ODMxMzg2MDB9.Q4sMAgq7ps0Ze5P32VEYVzFCcUqH0LKO24OebB2lup8";
   private ResponseEntity<Object> responseEntity;
   private AuthenticationProviderImpl authenticationProvider;

   @BeforeEach
   public void setUp() {
       String password = "mock_password";
       when(authentication.getName()).thenReturn("mock_user");
       when(authentication.getCredentials()).thenReturn(password);
       authenticationProvider = new AuthenticationProviderImpl(feignAuthorizationServer,jwtUtility, session);
       HttpHeaders header = new HttpHeaders();
       header.set("Authorization", tokenString);
       responseEntity = new ResponseEntity<>("", header, HttpStatus.OK);
   }

   @Test
   public void testAuthenticateIsAuthenticated() throws Exception {
       when(feignAuthorizationServer.authenticateUser(any())).thenReturn(responseEntity);
       Authentication authenticate = authenticationProvider.authenticate(authentication);
       verify(feignAuthorizationServer, atLeast(1)).authenticateUser(any());
       assertEquals(authenticate.getName(), authenticate.getName());

   }

   @Test
   public void testAuthenticateThrowsFeignExceptionWhenUsernameOrPasswordIsInvalid() {
       when(feignAuthorizationServer.authenticateUser(any())).thenThrow(FeignException.class);
       assertThrows(BadCredentialsException.class, () ->authenticationProvider.authenticate(authentication));
   }

   @Test
   public void testSupports() {
       assertFalse(authenticationProvider.supports(AuthenticationProviderImpl.class));
   }


}