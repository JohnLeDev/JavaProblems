package com.lean.demoSpringSecurity.common;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.lean.demoSpringSecurity.model.BaseContent;



public class ReponseEntity {
	public static ResponseEntity<Object> reponseSuccess(Object reponseObjec ,HttpStatus status){
		BaseContent content = new BaseContent() ; 
		content.setContent(reponseObjec);
		
		return new ResponseEntity<Object>(content, status);
		
	}
	
}
