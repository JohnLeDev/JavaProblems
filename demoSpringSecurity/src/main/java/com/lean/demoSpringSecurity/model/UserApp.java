package com.lean.demoSpringSecurity.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table
@NamedQuery(name = "userApp.findByUser" , query = "SELECT c FROM UserApp c WHERE userApp = :username")
public class UserApp {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String userApp;
	private String passwordApp;
	private String nameUser;
	
}
