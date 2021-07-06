package com.java.bean;

public class AdministratorsBean {
	private	String aid;
	private	String anum;
	private	String apassword;
	private	String aname;
	private String aposition;
	public String getAid() {
		return aid;
	}
	public void setAid(String aid) {
		this.aid = aid;
	}
	public String getAnum() {
		return anum;
	}
	public void setAnum(String anum) {
		this.anum = anum;
	}
	public String getApassword() {
		return apassword;
	}
	public void setApassword(String apassword) {
		this.apassword = apassword;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getAposition() {
		return aposition;
	}
	public void setAposition(String aposition) {
		this.aposition = aposition;
	}
	@Override
	public String toString() {
		return "AdministratorsBean [aid=" + aid + ", anum=" + anum + ", apassword=" + apassword + ", aname=" + aname
				+ ", aposition=" + aposition + "]" + "/r/n";
	}
	
}
