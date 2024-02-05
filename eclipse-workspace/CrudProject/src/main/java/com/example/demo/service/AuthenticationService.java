
package com.example.demo.service;

import com.example.demo.modal.User;
import com.example.demo.requestDto.SignInRequest;
import com.example.demo.requestDto.SignUpDto;
import com.example.demo.responseDto.JwtResponse;

public interface AuthenticationService {
	  User signUp(SignUpDto signUpDto);
	  JwtResponse signIn(SignInRequest signInRequest);
}
