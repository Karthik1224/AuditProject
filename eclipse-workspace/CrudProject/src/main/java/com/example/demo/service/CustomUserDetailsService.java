package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.modal.User;

import ch.qos.logback.classic.Logger;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;
	
	private static final Logger log = (Logger) LoggerFactory.getLogger(CustomUserDetailsService.class);

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// load user from the database
     
		try {

			User user = userRepo.findByEmail("karthikd20009@gmail.com");
			log.info("user data :{}" ,user);
			return user;
		} catch (Exception e) {
			throw new UsernameNotFoundException("user not found");
		}
		
	}

}
