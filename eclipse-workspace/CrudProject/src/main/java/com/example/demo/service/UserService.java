package com.example.demo.service;

import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dao.UserRepo;
import com.example.demo.modal.User;

import ch.qos.logback.classic.Logger;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	private static final Logger log = (Logger) LoggerFactory.getLogger(UserService.class);
	@Autowired
	private PasswordEncoder passwordEncoder;
	public List<User> getUsers()
	{
		User user = userRepo.findByEmail("karthikd20009@gmail.com");
		log.info("user information :{}",user);
		return userRepo.findAll();
	}
	
	public User createUser(User user)
	{
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		return userRepo.save(user);
	}
}
