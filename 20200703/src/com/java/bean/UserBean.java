package com.java.bean;

public class UserBean {
	private String cid;
	private String cphonenumber;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCphonenumber() {
		return cphonenumber;
	}
	public void setCphonenumber(String cphonenumber) {
		this.cphonenumber = cphonenumber;
	}
	@Override
	public String toString() {
		return "UserBean [cid=" + cid + ", cphonenumber=" + cphonenumber + "]";
	}
	
}
