package com.example.demo.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.User;
import com.example.demo.service.CustomUserDetailsService;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/home")
public class HomeController {

	@Autowired
	private UserService userService;

	
	@GetMapping("/getUsers")
	public List<User> getUser()
	{
		return userService.getUsers();
	}
}
