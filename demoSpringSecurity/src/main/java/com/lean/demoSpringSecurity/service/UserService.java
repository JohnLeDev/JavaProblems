package com.lean.demoSpringSecurity.service;

import org.springframework.stereotype.Service;

import com.lean.demoSpringSecurity.model.UserApp;


public interface UserService {
	
	public String register(UserApp user);
}
