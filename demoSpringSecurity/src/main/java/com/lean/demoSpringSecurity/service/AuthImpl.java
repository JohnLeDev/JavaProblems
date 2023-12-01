package com.lean.demoSpringSecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lean.demoSpringSecurity.AppConfig.JwtTokenProvider;
import com.lean.demoSpringSecurity.model.UserApp;

@Service
public class AuthImpl implements AuthCustomerService{
	
	@Autowired
    private PasswordEncoder encode;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserResponsitory userResponsitory;
	
	@Autowired
	private JwtTokenProvider jwtTokenProvider;
	@Override
	public String login(UserApp userappp) {
		Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userappp.getUserApp(),userappp.getPasswordApp()));
		SecurityContextHolder.getContext().setAuthentication(auth);
		String token = jwtTokenProvider.generateToken(auth);

        return token;
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
