package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.User;
import com.example.demo.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public ResponseObj addUser(User user)
	{
		ResponseObj obj = new ResponseObj();
		userRepository.save(user);
		obj.setStatus("SUCCESS");
		return obj;
	}
}
