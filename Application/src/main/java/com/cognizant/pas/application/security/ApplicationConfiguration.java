package com.cognizant.pas.application.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.cognizant.pas.application.service.AuthenticationProviderImpl;

@Configuration
@EnableWebSecurity
public class ApplicationConfiguration extends WebSecurityConfigurerAdapter {

	private final AuthenticationProviderImpl authenticationProvider;

	@Autowired
	public ApplicationConfiguration(AuthenticationProviderImpl authenticationProvider) {
		this.authenticationProvider = authenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(
				request -> request.antMatchers("/webjars/**", "/css/**", "/images/**", "/fonts/**").permitAll()
						.antMatchers("/swagger-resources/**", "/v2/api-docs", "/configuration/ui",
								"/swagger-resources/**", "/configuration/security", "/swagger-ui.html", "/webjars/**")
						.permitAll().anyRequest().authenticated())
				.formLogin(login -> login.loginPage("/account/login").loginProcessingUrl("/account/login")
						.usernameParameter("email").passwordParameter("password").permitAll());
	}
}
