package com.java.bean;

public class commodityBean {
	private String coid;
	private String coname;
	private String coprice;
	private String costock;
	
	public String getCoid() {
		return coid;
	}
	public void setCoid(String coid) {
		this.coid = coid;
	}
	public String getConame() {
		return coname;
	}
	public void setConame(String coname) {
		this.coname = coname;
	}
	public String getCoprice() {
		return coprice;
	}
	public void setCoprice(String coprice) {
		this.coprice = coprice;
	}
	public String getCostock() {
		return costock;
	}
	public void setCostock(String costock) {
		this.costock = costock;
	}
	@Override
	public String toString() {
		return "commodityBean [coid=" + coid + ", coname=" + coname + ", coprice=" + coprice + ", costock=" + costock
				+ "]";
	}
	
}
