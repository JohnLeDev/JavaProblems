package com.lean.demoSpringSecurity.service;

import java.util.List;

import com.lean.demoSpringSecurity.model.UserApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomeUserAppRespositoryImp implements CustomeUserAppRespository  {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<UserApp> findUserByName(String username, String password) {
		// TODO Auto-generated method stub
		entityManager.createNamedQuery("hit le");
		return null;
	}

}
