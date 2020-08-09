package com.cognizant.pas.consumer.payload.request;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsernamePasswordRequest {

    private String username;
    private String password;
}
