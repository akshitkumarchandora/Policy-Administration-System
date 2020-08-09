package com.cognizant.pas.AuthorizationServer.jwt;

import com.cognizant.pas.AuthorizationServer.model.UsernamePasswordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AuthenticationTest {

    private MockMvc mockMvc;
    @Autowired
    private WebApplicationContext context;
    private UsernamePasswordRequest usernamePasswordRequest;

    @BeforeEach
    public void setUp() throws Exception {
        usernamePasswordRequest = new UsernamePasswordRequest();
        usernamePasswordRequest.setUsername("amith");
        usernamePasswordRequest.setPassword("amith");
        mockMvc = MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
    }


    @Test
    public void testAuthentication_isSuccessful_whenTheUserExists() throws Exception {
        mockMvc.perform(post("/account/login").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(usernamePasswordRequest))).andExpect(status().isOk());
    }

    @Test
    public void testAuthentication_isSuccessful_andReturnsToken() throws Exception {
        String token = mockMvc.perform(post("/account/login").contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(usernamePasswordRequest)))
                .andExpect(status().isOk()).andReturn().getResponse().getHeader("Authorization");
        assertTrue(token.startsWith("Bearer "));
    }

    @Test
    public void testAuthentication_isUnsuccessful_whenPassedInvalidUserDetails() throws Exception {
        usernamePasswordRequest = new UsernamePasswordRequest();
        usernamePasswordRequest.setUsername("mock_user");
        usernamePasswordRequest.setPassword("mock_password");
        mockMvc.perform(post("/account/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(usernamePasswordRequest)))
                .andExpect(status().isUnauthorized());
    }
}
