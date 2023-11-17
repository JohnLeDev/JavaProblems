package com.lean.demoSpringSecurity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lean.demoSpringSecurity.model.UserApp;


@Service
public class UserService {
	
	@Autowired
	private UserResponsitory userResponsitory;
	
	@Autowired
    private PasswordEncoder encode;
	
	public boolean login(UserApp user){
		return false;
	}
	
	public boolean logout() {
		return false;
	}
	
	public Object register(UserApp user) {
		encode
		return null;
	}

}
