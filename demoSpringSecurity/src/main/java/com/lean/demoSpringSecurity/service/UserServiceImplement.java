package com.lean.demoSpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lean.demoSpringSecurity.model.UserApp;


@Service
public class UserServiceImplement implements UserService{
	
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
	
	@Override
	public String register(UserApp user) {
		List<UserApp> userList =  userResponsitory.getUserAppCustom(user.getUserApp(), user.getPasswordApp());
		if( !userList.isEmpty()) {
			return "user is existed";
		}
		user.setPasswordApp(encode.encode(user.getPasswordApp()));
		userResponsitory.save(user);
		return "create successs";
	}

}
