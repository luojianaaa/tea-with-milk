package com.java.bean;

import java.util.HashMap;
import java.util.Map;

public class glydlFormBean {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	private Map<String, String> errors = new HashMap<String, String>();
	
	public Map<String, String> getErrors() {
		return errors;
	}
	
	public void setErroMsg(String err,String errMsg) {
		if ((err != null) && (errMsg) != null) {
			errors.put(err, errMsg);
		}
	}
	
	public boolean validate() {
		boolean flag = true;
		
		if (username == null || username.trim().equals("")) {
			errors.put("username", "请输入账号");
			flag = false;
		}
		
		if (password == null || password.trim().equals("")) {
			errors.put("password", "请输入密码");
			flag = false;
		}
		
		return flag;
	}
}
