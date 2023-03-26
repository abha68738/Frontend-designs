package com.credify.CustomerData;

public class SingleCustomer {

	
private  ShopifyCustomer customer;

public ShopifyCustomer getCustomer() {
	return customer;
}

@Override
public String toString() {
	return "SingleCustomer [customer=" + customer + "]";
}

public void setCustomer(ShopifyCustomer customer) {
	this.customer = customer;
}
	
	
}
