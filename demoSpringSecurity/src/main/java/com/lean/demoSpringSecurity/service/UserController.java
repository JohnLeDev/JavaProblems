package com.lean.demoSpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lean.demoSpringSecurity.common.ReponseEntity;
import com.lean.demoSpringSecurity.model.UserApp;

@RestController
@RequestMapping("user")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	@RequestMapping("register")
	public ResponseEntity<Object> registerUser(@RequestBody UserApp user ) {
		String msg =  userService.register(user);
		return ReponseEntity.reponseSuccess(msg, HttpStatus.ACCEPTED); 
	} 
	
	@PostMapping
	@RequestMapping("login")
	public ResponseEntity<Object> login(@RequestBody UserApp user ) {
		return null;
	}
	
	
	
}
