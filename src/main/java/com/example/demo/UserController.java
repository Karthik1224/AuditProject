package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	
	@PostMapping("/addUser")
	public ResponseEntity<?> addUser(@RequestBody User user)
	{
		try {
			userService.addUser(user);
			return new ResponseEntity(userService.addUser(user), HttpStatus.OK);
		} catch (Exception e) {
			ResponseObj obj = new ResponseObj();
			obj.setStatus("failure");
			return new ResponseEntity(obj, HttpStatus.OK);
		}
	}
}
