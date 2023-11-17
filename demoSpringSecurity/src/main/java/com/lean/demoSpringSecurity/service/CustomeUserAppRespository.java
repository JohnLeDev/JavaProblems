package com.lean.demoSpringSecurity.service;

import java.util.List;

import com.lean.demoSpringSecurity.model.UserApp;

public interface CustomeUserAppRespository {
	List<UserApp> findUserByName(String username, String password);
}
