package com.credex.services;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.credex.client.ApiCalls;

import constant.EndPoint;

@Component
public  class SeviceLayeImplementation implements ServiceLayer{

//	private String SHOPIFY_STORE_DOMAIN = "aakritiproject.myshopify.com";
//	private String SHOPIFY_TOKKEN = "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";

	private static final Logger LOGGER = LoggerFactory.getLogger(ApiCalls.class);
	
	public JSONObject getApiWithStatus(String endPoint, String status) throws Exception {
		URL url = new URL(
				"https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/" + endPoint + ".json?status=" + status);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject json = new JSONObject(response.toString());
			LOGGER.info(json.toString());
			if (json.toString() != null) {
				return json;
			}
		}
		throw new RuntimeException("Invalid Input");
	}
	
	public JSONObject loginAndGetApiCalls(String Endpoint) throws Exception {

		URL url = new URL("https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/" + Endpoint + ".json");

		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		int responseCode = conn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject json = new JSONObject(response.toString());

			LOGGER.info(json.toString());

			if (json.length() != 0) {
				return json;
			}

		} else {
			System.out.println("GET request failed, response code: " + responseCode);
		}
		return null;
	}
	
	
	public JSONObject getDataById(String endPoint, Long Id) throws Exception {
		URL url = new URL("https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/" + endPoint + "/" + Id + ".json");
		// System.out.println("Api Hit");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject json = new JSONObject(response.toString());
			LOGGER.info(json.toString());
			if (json.toString() != null) {
				return json;
			}
		}
		throw new RuntimeException("Invalid Input");
	}

	public JSONObject deleteDataById(Long Id) throws Exception {
		URL url = new URL("https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/customers/" + Id + ".json");
		// System.out.println("Api Hit");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("DELETE");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject json = new JSONObject(response.toString());
			LOGGER.info(json.toString());
			if (json.toString() != null) {
				return json;
			}
		}
		throw new RuntimeException("Invalid Input");
	}
	
	
	public JSONObject CreateCustomer(JSONObject customerData) throws Exception {
		String jsonInputString = customerData.toString();
		URL url = new URL("https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/customers.json");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		conn.setDoOutput(true);
		OutputStream os = conn.getOutputStream();
		os.write(jsonInputString.toString().getBytes());
		os.flush();
		os.close();
		int responseCode = conn.getResponseCode();
		if (responseCode == HttpURLConnection.HTTP_CREATED) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject jsonResponse = new JSONObject(response.toString());
			LOGGER.info(jsonResponse.toString());
			System.out.println(jsonResponse.toString());
			return jsonResponse;
		} else {
			throw new RuntimeException("Failed to create product. Response code: " + responseCode);
		}
	}
	
	public JSONObject updateDataById(Long customerId, String email, String first_name, String last_name, Long phone)
			throws Exception {
		URL url = new URL("https://" + EndPoint.SHOPIFY_STORE_DOMAIN + "/admin/api/2022-10/customers/" + customerId + ".json");
		System.out.println("inide api calls method***");
		System.out.println("last name:" + last_name);
		System.out.println(email);
		System.out.println(first_name);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		//System.out.println("line 190**");
		conn.setRequestMethod("PUT");
		conn.setRequestProperty("Content-Type", "application/json");
		conn.setRequestProperty("X-Shopify-Access-Token", EndPoint.SHOPIFY_TOKKEN);
		// Create the json to update customer
		JSONObject customerJson = new JSONObject();
		customerJson.put("email", email);
		customerJson.put("first_name", first_name);
		customerJson.put("last_name", last_name);
		customerJson.put("phone", phone);

		JSONObject payloadJson = new JSONObject();
		payloadJson.put("customer", customerJson);
		// Add the payload to the request body
		String payloadString = payloadJson.toString();
		conn.setDoOutput(true);
		DataOutputStream outStream = new DataOutputStream(conn.getOutputStream());
		outStream.writeBytes(payloadString);
		outStream.flush();
		outStream.close();

		if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();
			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();
			JSONObject json = new JSONObject(response.toString());
			LOGGER.info(json.toString());

			return json;

		}
		throw new RuntimeException("Invalid Input");
	}
	
	
	
	
	
}


