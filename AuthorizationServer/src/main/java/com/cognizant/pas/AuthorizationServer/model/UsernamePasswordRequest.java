package com.cognizant.pas.AuthorizationServer.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsernamePasswordRequest {

    private String username;
    private String password;
}
