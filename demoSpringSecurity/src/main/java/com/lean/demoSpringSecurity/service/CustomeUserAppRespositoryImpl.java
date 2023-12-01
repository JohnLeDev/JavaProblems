package com.lean.demoSpringSecurity.service;

import java.util.List;

import com.lean.demoSpringSecurity.model.UserApp;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

public class CustomeUserAppRespositoryImpl implements CustomeUserAppRespository  {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<UserApp> getUserAppCustom(String username, String password) {
		// TODO Auto-generated method stub
		List<UserApp> data = entityManager.createNamedQuery("userApp.findByUser")
		.setParameter("username",username).getResultList();
		return data;
	}

}
