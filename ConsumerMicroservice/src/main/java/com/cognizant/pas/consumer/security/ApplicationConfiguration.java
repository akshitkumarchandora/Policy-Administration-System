package com.cognizant.pas.consumer.security;

import com.cognizant.pas.consumer.service.AuthenticationProviderImpl;
import com.cognizant.pas.consumer.jwt.JwtTokenVerifier;
import com.cognizant.pas.consumer.jwt.JwtUtility;
import com.cognizant.pas.consumer.jwt.UsernamePasswordAuthenticationFilterImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {

	private final AuthenticationProviderImpl authenticationProvider;
	private final JwtUtility jwtUtility;

	@Autowired
	public ApplicationConfiguration(AuthenticationProviderImpl authenticationProvider, JwtUtility jwtUtility) {
		this.authenticationProvider = authenticationProvider;
		this.jwtUtility = jwtUtility;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf(csrf -> csrf.disable())
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeRequests(request -> request
						.antMatchers("/swagger-resources/**", "/v2/api-docs", "/configuration/ui",
								"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**")
						.permitAll()
						.antMatchers("/h2-console/**", "/h2-console/login.do**", "/viewConsumerBusinessByPolicy")
						.permitAll().antMatchers("/manage/**").permitAll().anyRequest().authenticated())
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
