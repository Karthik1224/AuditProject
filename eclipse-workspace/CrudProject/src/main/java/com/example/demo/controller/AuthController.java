package com.example.demo.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.User;
import com.example.demo.requestDto.SignInRequest;
import com.example.demo.requestDto.SignUpDto;
import com.example.demo.responseDto.JwtResponse;
import com.example.demo.service.AuthenticationService;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

	@Autowired
	private AuthenticationService authService;
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(AuthController.class);

	@PostMapping("/register")
	public ResponseEntity<User> registerUser(@RequestBody SignUpDto request){
		log.info("registerUser request processed");

		return ResponseEntity.ok(authService.signUp(request));

	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse>login(@RequestBody SignInRequest request)
	{
		return ResponseEntity.ok(authService.signIn(request));
	}

}
