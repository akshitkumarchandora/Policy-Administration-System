package com.cognizant.pas.application.service;

import feign.FeignException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.cognizant.pas.application.model.JwtUtility;
import com.cognizant.pas.application.model.UsernamePasswordRequest;
import com.cognizant.pas.application.restclients.FeignAuthorizationServer;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

    private final FeignAuthorizationServer authorizationServer;
    private final JwtUtility jwtUtility;
    private final HttpSession session;

    @Autowired
    public AuthenticationProviderImpl(FeignAuthorizationServer authorizationServer, JwtUtility jwtUtility, HttpSession session) {
        this.authorizationServer = authorizationServer;
        this.jwtUtility = jwtUtility;
        this.session = session;
    }


    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        UsernamePasswordRequest usernamePasswordRequest = new UsernamePasswordRequest(authentication.getName(),
                authentication.getCredentials().toString());
        try {
            log.info("{}, Information: Attempting to authenticate the user", this.getClass().getSimpleName());
            ResponseEntity<Object> objectResponseEntity = authorizationServer.authenticateUser(usernamePasswordRequest);
            String token = objectResponseEntity.getHeaders().get(jwtUtility.getTokenHeader()).get(0);
            session.setAttribute("token", token);
            log.info("{}, Information: Successfully authenticated user", this.getClass().getSimpleName());
            return extractDetailsFromToken(token);
        }
        catch (FeignException e) {
            log.debug("{}, Information: Cannot authenticate user invalid credentials", this.getClass().getSimpleName());
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
