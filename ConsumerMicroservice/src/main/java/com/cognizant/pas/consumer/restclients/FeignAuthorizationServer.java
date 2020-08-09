package com.cognizant.pas.consumer.restclients;


import com.cognizant.pas.consumer.payload.request.UsernamePasswordRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "AuthorizationServer", url = "${AUTHORIZATION_SERVICE:http://localhost:8080}")
public interface FeignAuthorizationServer {

    @PostMapping(value = "/account/login")
    public ResponseEntity<Object> authenticateUser(@RequestBody UsernamePasswordRequest usernamePasswordRequest);
}
