package com.lean.demoSpringSecurity.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lean.demoSpringSecurity.model.UserApp;

@Repository
public interface UserResponsitory extends CrudRepository<UserApp, Long>, CustomeUserAppRespository {
	 
}
