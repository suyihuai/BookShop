package com.vince.entity;

public class Count {
	private String name;
	private String password;
	private String type;
	public Count(String name, String password, String type) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
	}
	public Count() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Count [name=" + name + ", password=" + password + ", type="
				+ type + "]";
	}
	
	
}
