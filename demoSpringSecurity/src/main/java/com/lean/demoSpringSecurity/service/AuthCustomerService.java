package com.lean.demoSpringSecurity.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.lean.demoSpringSecurity.model.UserApp;

public interface AuthCustomerService {
	public String login(UserApp userappp);
	public String register(UserApp user);
}
