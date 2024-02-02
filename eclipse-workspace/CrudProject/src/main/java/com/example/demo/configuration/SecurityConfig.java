package com.example.demo.configuration;

import java.beans.Customizer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.demo.security.JwtAuthenticationEntryPoint;
import com.example.demo.security.JwtAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private JwtAuthenticationEntryPoint point;
	@Autowired
	private JwtAuthenticationFilter filter;
   
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@SuppressWarnings("removal")
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

		http
		.csrf(csrf -> csrf.disable())
		.exceptionHandling()
		.authenticationEntryPoint(point)
		.and()
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
		.and()
		.authorizeRequests()
		.requestMatchers("/auth/login").permitAll()
		.requestMatchers("/auth/addUser").permitAll()
		.anyRequest().authenticated()
		.and()
		.httpBasic();
		http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
		return http.build();
	}
	
	@Bean
	public DaoAuthenticationProvider daoAuthenticationProvider()
	{
		DaoAuthenticationProvider authenticationPro = new DaoAuthenticationProvider();
		authenticationPro.setPasswordEncoder(passwordEncoder);
		authenticationPro.setUserDetailsService(userDetailsService);
		return authenticationPro;
	}

}
