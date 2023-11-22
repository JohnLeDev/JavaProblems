package com.lean.demoSpringSecurity.service;

import java.util.List;

import com.lean.demoSpringSecurity.model.UserApp;

public interface CustomeUserAppRespository {
	List<UserApp> getUserAppCustom( String username, String password);
}
