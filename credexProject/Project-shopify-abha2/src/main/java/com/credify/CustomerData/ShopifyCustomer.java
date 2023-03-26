package com.credify.CustomerData;

import java.util.Arrays;

public class ShopifyCustomer {

 @Override
public String toString() {
	return "ShopifyCustomer [orders_count=" + orders_count + ", last_order_name=" + last_order_name + ", last_order_id="
			+ last_order_id + ", email=" + email + ", first_name=" + first_name + ", last_name=" + last_name
			+ ", State=" + State + ", address=" + Arrays.toString(address) + ", phone=" + phone + ", id=" + id + "]";
}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getFirst_name() {
	return first_name;
}
public void setFirst_name(String first_name) {
	this.first_name = first_name;
}
public String getLast_name() {
	return last_name;
}
public void setLast_name(String last_name) {
	this.last_name = last_name;
}
public String getState() {
	return State;
}
public void setState(String state) {
	State = state;
}
public Address[] getAddress() {
	return address;
}
public void setAddress(Address[] address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}

 
 public long getOrders_count() {
	return orders_count;
}
public void setOrders_count(long orders_count) {
	this.orders_count = orders_count;
}
public String getLast_order_name() {
	return last_order_name;
}
public void setLast_order_name(String last_order_name) {
	this.last_order_name = last_order_name;
}
public long getLast_order_id() {
	return last_order_id;
}
public void setLast_order_id(long last_order_id) {
	this.last_order_id = last_order_id;
}
private long orders_count;
private String last_order_name;
 private long last_order_id;
 private String email;
 private String first_name;
 private String last_name;
 private String State;
 private Address address[];
 private long phone;
 private long id;

 
	
}
