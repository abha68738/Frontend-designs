package com.credify.RestControllers;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.credex.client.ApiCalls;
import com.credex.services.ServiceLayer;
import com.credify.CustomerData.ShopifyCustomer;
import com.credify.CustomerData.ShopifyCustomersResponse;
import com.credify.CustomerData.SingleCustomer;
import com.google.gson.Gson;

import constant.EndPoint;

@Controller
public class Customer {

	@Autowired
	ServiceLayer services;
	
	@RequestMapping("/customerForm")
	public String CustomerForm() {
		return "customerForm";
	}
	@RequestMapping("/customers")
	public String CustomPage() {
		return "customers";
	}
	
	
	
	
	@GetMapping("/customers")
	public String customerView(HttpSession session, Model model) throws Exception {
         
		JSONObject jsonObject = services.loginAndGetApiCalls("customers");
		String storeName=(String) session.getAttribute("storeName");
		if (!Objects.isNull(jsonObject)&&storeName.equals(EndPoint.SHOPIFY_STORE_DOMAIN)) {
			ShopifyCustomersResponse responseCustomer = new Gson().fromJson(jsonObject.toString(),
					ShopifyCustomersResponse.class);
			ShopifyCustomer[] customers = responseCustomer.getCustomer();
			System.out.println("Printing customer " + customers);
			model.addAttribute("customers", customers);
			return "customers";
		} else {
			return "Dashboard";
		}
	}
	
	
	
	
	@RequestMapping(value = "/singleCustomer", method = RequestMethod.POST)
	public String singleCustomersDetails(@RequestParam("id") Long id, HttpSession session, Model model)
			throws Exception {


		JSONObject customerJson = services.getDataById("customers", id);
	//	System.out.printf("This is the customer in json Format", customerJson);
		String storeName=(String) session.getAttribute("storeName");

		if (!Objects.isNull(customerJson)&&storeName.equals(EndPoint.SHOPIFY_STORE_DOMAIN)) {

			System.out.println("Here are the customers");

			ShopifyCustomer customer = new Gson().fromJson(customerJson.toString(), SingleCustomer.class).getCustomer();


			model.addAttribute("customers", customer);

			return "singleCustomer";
		} else {
			return "customers";
		}
	}
	
	
	
	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
	public ModelAndView handleRequest(@RequestParam("id") Long id, HttpSession session, Model model) throws Exception {
		{
			ModelAndView modelAndView = new ModelAndView();
			String storeName=(String) session.getAttribute("storeName");

          if(storeName.equals(EndPoint.SHOPIFY_STORE_DOMAIN)) {
        		JSONObject customerJson = services.deleteDataById(id);
        		//	System.out.printf("This customer has been deleted", customerJson);
                    
        			modelAndView.setViewName("redirect:customers");
        			return modelAndView;  
          }
}
		return null;
             
		
	}
	
	
	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
	public ModelAndView handleRequest(HttpSession session, HttpServletRequest request, Model model) throws Exception {
		{

			ModelAndView modelAndView = new ModelAndView();

			String first_name = request.getParameter("first_name");
			String last_name = request.getParameter("last_name");
			String email = request.getParameter("email");

			long phone = Long.parseLong(request.getParameter("phone"));
			//System.out.println(email);
			JSONObject customers = new JSONObject();
			customers.put("customer", new JSONObject().put("first_name", first_name).put("last_name", last_name)
					.put("email", email).put("phone", phone));
			System.out.println("customers adding" + customers);

			JSONObject customersJson5 = services.CreateCustomer(customers);
			Gson gson = new Gson();
			ShopifyCustomer customer = new Gson().fromJson(customersJson5.toString(), SingleCustomer.class)
					.getCustomer();

			modelAndView.setViewName("redirect:customers");
			return modelAndView;

		}
	}
	
	
	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
	public String updateCustomer(HttpSession session, HttpServletRequest request, Model model,
			@RequestParam("id") Long customerId) throws Exception {
	//	System.out.println("Id is " + customerId);
		model.addAttribute("id", customerId);
		return "updateCustomer";
	}
	
	
	
	@RequestMapping(value = "/updateDataById", method = RequestMethod.POST)
	public String updatecustomerAction(@RequestParam("customerId") Long customerId, @RequestParam("email") String email,
			@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,
			@RequestParam("phone") Long phone, HttpSession session, Model model) throws Exception {
		String storeName=(String) session.getAttribute("storeName");
		JSONObject response = services.updateDataById(customerId, email, first_name, last_name, phone);
		
		
		System.out.println(response.toString());
		if (!Objects.isNull(response)&&equals(EndPoint.SHOPIFY_STORE_DOMAIN)) {
			ShopifyCustomer customerObject = new Gson().fromJson(response.toString(), SingleCustomer.class)
					.getCustomer();
			model.addAttribute("customers", customerObject);
			return "singleCustomer";
		} else {
			return "customers";
		}
	}
	
	
	
	
	
	
}
