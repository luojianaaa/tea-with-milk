package com.java.bean;

import java.util.HashMap;
import java.util.Map;

public class RegisterFormBean {
	private String phonenumber;
	private String Lcheck_code;
	private String Scheck_code;

	public String getScheck_code() {
		return Scheck_code;
	}

	public void setScheck_code(String scheck_code) {
		Scheck_code = scheck_code;
	}

	public String getLcheck_code() {
		return Lcheck_code;
	}

	public void setLcheck_code(String lcheck_code) {
		Lcheck_code = lcheck_code;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
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
		
		if (phonenumber == null || phonenumber.trim().equals("")) {
			errors.put("phonenumber", "请输入手机号码");
			flag = false;
		}else if (!phonenumber.matches("^1(3|4|5|7|8)\\d{9}$")) {
			errors.put("phonenumber", "手机号码有误，请重填");
			flag = false;
		}
		
		if (!Lcheck_code.equals(Scheck_code)) {
			errors.put("check_code", "验证码错误");
			flag = false;
		}
		
		return flag;
	}
}
