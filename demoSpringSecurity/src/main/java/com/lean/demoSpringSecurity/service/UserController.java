package com.lean.demoSpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
	@Autowired
	private AuthCustomerService authCustomerService;
	
	@GetMapping
	@RequestMapping("v1/hello")
	public ResponseEntity<Object> registerUsesssr() {
		
		return ReponseEntity.reponseSuccess("asdasdas", HttpStatus.ACCEPTED);
	}
	
	@PostMapping
	@RequestMapping("v1/register")
	public ResponseEntity<Object> registerUser(@RequestBody UserApp user) {
		String msg = authCustomerService.register(user);
		return ReponseEntity.reponseSuccess(msg, HttpStatus.ACCEPTED);
	}

	@PostMapping
	@RequestMapping("v1/login")
	public ResponseEntity<Object> login(@RequestBody UserApp user) {
		
		
		String jwt = authCustomerService.login(user);
		return ReponseEntity.reponseSuccess(jwt, HttpStatus.ACCEPTED);
	}

}
