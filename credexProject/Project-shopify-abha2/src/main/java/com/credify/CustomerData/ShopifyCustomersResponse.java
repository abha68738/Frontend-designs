package com.credify.CustomerData;

import java.util.Arrays;

public class ShopifyCustomersResponse {
	ShopifyCustomer[] customers;

	@Override
	public String toString() {
		return "ShopifyCustomersResponse [customers=" + Arrays.toString(customers) + "]";
	}

	public ShopifyCustomer[] getCustomer() {
		return customers;
	}

	public void setCustomer(ShopifyCustomer[] customer) {
		customers = customers;
	}



	
}
