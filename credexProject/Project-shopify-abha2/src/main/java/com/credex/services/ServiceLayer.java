package com.credex.services;

import org.json.JSONObject;
import org.springframework.stereotype.Service;


@Service
public interface ServiceLayer {

	JSONObject getApiWithStatus(String endPoint, String status) throws Exception ;
	JSONObject loginAndGetApiCalls(String Endpoint) throws Exception;
	 JSONObject getDataById(String endPoint, Long Id) throws Exception;
	 JSONObject deleteDataById(Long Id) throws Exception;
	 JSONObject CreateCustomer(JSONObject customerData) throws Exception;
	 JSONObject updateDataById(Long customerId, String email, String first_name, String last_name, Long phone) throws Exception;
}
