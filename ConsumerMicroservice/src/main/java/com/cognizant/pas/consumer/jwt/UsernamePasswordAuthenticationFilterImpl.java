package com.cognizant.pas.consumer.jwt;

import com.cognizant.pas.consumer.payload.request.UsernamePasswordRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
public class UsernamePasswordAuthenticationFilterImpl extends UsernamePasswordAuthenticationFilter {

    private final AuthenticationManager authenticationManager;
    private final JwtUtility jwtUtility;

    public UsernamePasswordAuthenticationFilterImpl(AuthenticationManager authenticationManager,
                                                    JwtUtility jwtUtility) {
        this.authenticationManager = authenticationManager;
        this.jwtUtility = jwtUtility;
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("{}, Information: Attempting to authenticate user", this.getClass().getSimpleName());
        try {
            UsernamePasswordRequest usernamePasswordRequest = new ObjectMapper()
                    .readValue(request.getInputStream(), UsernamePasswordRequest.class);
            Authentication authentication = new UsernamePasswordAuthenticationToken(
                    usernamePasswordRequest.getUsername(),
                    usernamePasswordRequest.getPassword()
            );
            Authentication authenticate = authenticationManager.authenticate(authentication);
            return authenticate;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response,
                                            FilterChain chain, Authentication authResult) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(authResult.getName())
                .claim(jwtUtility.getClaimsName(), authResult.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(jwtUtility.getTokenExpirationDate())))
                .signWith(SignatureAlgorithm.HS256, jwtUtility.getSecretKey().getBytes())
                .compact();
        log.info("{}, Information: Successfully authenticated user", this.getClass().getSimpleName());
        response.addHeader(jwtUtility.getTokenHeader(), jwtUtility.getTokenPrefix() + " " + token);
    }
}
