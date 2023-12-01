package com.lean.demoSpringSecurity.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lean.demoSpringSecurity.common.ReponseEntity;
import com.lean.demoSpringSecurity.model.UserApp;

@RestController
@RequestMapping("v1")
public class TestAPIController {
	@GetMapping
	@RequestMapping("hello")
	public ResponseEntity<Object> registerUser(Authentication authentication) {
		
		return ReponseEntity.reponseSuccess("asdasdas", HttpStatus.ACCEPTED);
	}
}
