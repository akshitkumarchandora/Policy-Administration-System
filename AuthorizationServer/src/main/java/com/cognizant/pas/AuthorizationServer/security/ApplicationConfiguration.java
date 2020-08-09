package com.cognizant.pas.AuthorizationServer.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.pas.AuthorizationServer.jwt.JwtTokenVerifier;
import com.cognizant.pas.AuthorizationServer.jwt.JwtUtility;
import com.cognizant.pas.AuthorizationServer.jwt.UsernamePasswordAuthenticationFilterImpl;
import com.cognizant.pas.AuthorizationServer.service.UserDetailsServiceImpl;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {

	private final UserDetailsServiceImpl userDetailsService;
	private final JwtUtility jwtUtility;

	@Autowired
	public ApplicationConfiguration(UserDetailsServiceImpl userDetailsService, JwtUtility jwtUtility) {
		this.userDetailsService = userDetailsService;
		this.jwtUtility = jwtUtility;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeRequests(request -> request.antMatchers("/manage/**").permitAll().anyRequest().authenticated())
				.addFilter(this.usernamePasswordAuthenticationFilter(authenticationManager()))
				.addFilterAfter(new JwtTokenVerifier(jwtUtility), UsernamePasswordAuthenticationFilterImpl.class);
	}

	public UsernamePasswordAuthenticationFilterImpl usernamePasswordAuthenticationFilter(
			AuthenticationManager authenticationManager) {
		UsernamePasswordAuthenticationFilterImpl usernamePasswordAuthenticationFilter = new UsernamePasswordAuthenticationFilterImpl(
				authenticationManager, jwtUtility);
		usernamePasswordAuthenticationFilter.setFilterProcessesUrl("/account/login");
		return usernamePasswordAuthenticationFilter;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
