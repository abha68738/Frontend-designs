package com.credify.Admin;

public class Admin {
	private String storeName;
	
	private String password;
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [storeName=" + storeName + ", password=" + password + "]";
	}
}
