package com.cognizant.pas.AuthorizationServer.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.pas.AuthorizationServer.model.Authorities;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class AuthoritiesTest {


    private Authorities authorities;

    @BeforeEach
    public void setUp() {
        authorities = new Authorities();
        authorities.setId(1);
        authorities.setRole("ROLE_MOCK");
        authorities.setUsers(null);
    }

    @Test
    public void testAllGetterSetterConstructor() {
        assertEquals(1,authorities.getId());
        assertEquals("ROLE_MOCK",authorities.getRole());
        assertEquals(null,authorities.getUsers());
    }

}