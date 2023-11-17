package com.lean.demoSpringSecurity.service;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lean.demoSpringSecurity.model.UserApp;

@RestController
@RequestMapping("user")
public class UserController {
	
	@PostMapping
	@RequestMapping("register")
	public Object registerUser(@RequestBody UserApp user ) {
		return null;
	} 
	
	@PostMapping
	@RequestMapping("login")
	public Object login(@RequestBody UserApp user ) {
		return null;
	}
	
	
	
}
