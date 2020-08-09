package com.cognizant.pas.consumer.service;


import com.cognizant.pas.consumer.payload.request.*;
import com.cognizant.pas.consumer.restclients.*;
import com.cognizant.pas.consumer.jwt.*;
import feign.FeignException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final FeignAuthorizationServer authorizationServer;
    private final JwtUtility jwtUtility;

    @Autowired
    public AuthenticationProviderImpl(FeignAuthorizationServer authorizationServer, JwtUtility jwtUtility) {
        this.authorizationServer = authorizationServer;
        this.jwtUtility = jwtUtility;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        UsernamePasswordRequest usernamePasswordRequest = new UsernamePasswordRequest(authentication.getName(),
                authentication.getCredentials().toString());
        try {
            ResponseEntity<Object> objectResponseEntity = authorizationServer.authenticateUser(usernamePasswordRequest);
            String token = objectResponseEntity.getHeaders().get(jwtUtility.getTokenHeader()).get(0);
            return extractDetailsFromToken(token);
        }
        catch (FeignException e) {
            throw new BadCredentialsException("Invalid Credentials");
        }

    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    public UsernamePasswordAuthenticationToken extractDetailsFromToken(String token) {
        token = token.replace(jwtUtility.getTokenPrefix() + " ", "");
        Jws<Claims> claimsJws = Jwts.parser()
                .setSigningKey(jwtUtility.getSecretKey().getBytes())
                .parseClaimsJws(token);
        Claims body = claimsJws.getBody();
        String username = body.getSubject();
        List<Map<String,String>> authorities = (List<Map<String,String>>) body.get(jwtUtility.getClaimsName());
        Set<SimpleGrantedAuthority> authority = authorities.stream()
                .map(i -> new SimpleGrantedAuthority(i.get(jwtUtility.getAuthority()))).collect(Collectors.toSet());
        return new UsernamePasswordAuthenticationToken(
                username,
                "",
                authority
        );
    }
}
