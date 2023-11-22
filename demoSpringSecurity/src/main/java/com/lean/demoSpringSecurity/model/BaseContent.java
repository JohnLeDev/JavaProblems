package com.lean.demoSpringSecurity.model;

import java.util.Date;

import lombok.Data;

@Data
public class BaseContent {
	private Object content;
	private Date date = new Date();
	private boolean status = true ;
	private String errmessage;
}
