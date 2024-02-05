package com.example.demo.service.imple;


import lombok.RequiredArgsConstructor;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.modal.User;
import com.example.demo.requestDto.SignInRequest;
import com.example.demo.requestDto.SignUpDto;
import com.example.demo.responseDto.JwtResponse;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.JwtService;

import ch.qos.logback.classic.Logger;


@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService; 
    
    private static final Logger log = (Logger) LoggerFactory.getLogger(AuthenticationServiceImpl.class);
    public User signUp(SignUpDto signUpDto)
    {
    	log.info("signup request started");
        User user = new User();
        user.setEmail(signUpDto.getEmail());
        user.setName(signUpDto.getName());
        log.info("password :{}",signUpDto.getPassword());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));
        log.info("signup request end");
        return userRepo.save(user);
    }

    public JwtResponse signIn(SignInRequest signInRequest)
    {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(),signInRequest.getPassword()));
               UserDetails userDetails = userRepo.findByEmail(signInRequest.getEmail()).orElseThrow(()-> new IllegalArgumentException(" Invalid Username or Password  !!"));
               String token = jwtService.generateToken(userDetails);
               JwtResponse response = new JwtResponse();
               response.setJwtToken(token);
               return response;


    }

}
