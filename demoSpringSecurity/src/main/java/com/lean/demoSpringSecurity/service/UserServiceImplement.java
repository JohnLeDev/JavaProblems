package com.lean.demoSpringSecurity.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.lean.demoSpringSecurity.AppConfig.JwtTokenProvider;
import com.lean.demoSpringSecurity.model.UserApp;


@Service
public class UserServiceImplement implements UserService, UserDetailsService{
	
	@Autowired
	private UserResponsitory userResponsitory;
	
	
	
	
	public boolean logout() {
		return false;
	}
	
	@Override
	public String register(UserApp user) {
//		List<UserApp> userList =  userResponsitory.getUserAppCustom(user.getUserApp(), user.getPasswordApp());
//		if( !userList.isEmpty()) {
//			return "user is existed";
//		}
//		user.setPasswordApp(encode.encode(user.getPasswordApp()));
//		userResponsitory.save(user);
//		return "create successs";
		return null;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserApp userApp =new UserApp();
    	userApp.setUserApp(username); 
    	List<UserApp> users = userResponsitory.findByUserApp(username);
    	if(users!=null && !users.isEmpty() ) {
    		Set<GrantedAuthority> authorities = new HashSet<>();
        	authorities.add(new SimpleGrantedAuthority("User"));
        	return new User(username,users.get(0).getPasswordApp(),authorities);
    	}
    	return null;
	}

}
