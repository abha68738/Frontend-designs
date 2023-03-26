package com.credify.RestControllers;

import com.credex.client.ApiCalls;
import com.credex.services.ServiceLayer;
import com.credify.CustomerData.ShopifyCustomer;
import com.credify.CustomerData.ShopifyCustomersResponse;
import com.credify.CustomerData.SingleCustomer;
import com.google.gson.Gson;
import java.util.List;
import java.util.Objects;
import javax.servlet.http.*;
import javax.websocket.Session;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class RestControllers {
//	@Autowired
//	ServiceLayer services;
//
//	@RequestMapping("/")
//	public String Home() {
//		return "home";
//	}
//
//	@RequestMapping("/customerForm")
//	public String CustomerForm() {
//		return "customerForm";
//	}
//
//	@RequestMapping("/customers")
//	public String CustomPage() {
//		return "customers";
//	}
//
//	@RequestMapping(path = "/adminLogin", method = RequestMethod.GET)
//	public String AdminLogin() {
//
//		return "adminLogin";
//	}
//
//	@PostMapping("/adminLogin")
//	public String doLogin(HttpServletRequest request, @RequestParam String storeName, @RequestParam String password,
//			Model model) throws Exception {
//
//		JSONObject jsonObject = services.loginAndGetApiCalls("customers");
//		if (!Objects.isNull(jsonObject)) {
//			ShopifyCustomer[] customers = new Gson().fromJson(jsonObject.toString(), ShopifyCustomersResponse.class)
//					.getCustomer();
//
//			for (ShopifyCustomer custom : customers) {
//				System.out.println(custom);
//			}
//			for (int i = 0; i < customers.length; i++) {
//				System.out.println(customers[i].getId());
//
//			}
//			 System.out.println(jsonObject.toString());
//
//			HttpSession session = request.getSession();
//			session.setAttribute("storeName", storeName);
//			session.setAttribute("password", password);
//			model.addAttribute("num", customers.length);
//			// System.out.println("jsom data" + jsonObject.toString());
//			return "adminDashboard";
//		} else {
//			return "adminLogin";
//		}
//
//	}
//
//	@GetMapping("/customers")
//	public String productView(HttpSession sesssion, Model model) throws Exception {
//		String storeName = (String) sesssion.getAttribute("storeName");
//		String password = (String) sesssion.getAttribute("password");
//		ApiCalls apiCalls = new ApiCalls();
//		apiCalls.setSHOPIFY_STORE_DOMAIN(storeName);
//		apiCalls.setSHOPIFY_TOKKEN(password);
//		JSONObject jsonObject = services.loginAndGetApiCalls("customers");
//		if (!Objects.isNull(jsonObject)) {
//			ShopifyCustomersResponse responseCustomer = new Gson().fromJson(jsonObject.toString(),
//					ShopifyCustomersResponse.class);
//			ShopifyCustomer[] customers = responseCustomer.getCustomer();
//			System.out.println("Printing customer " + customers);
//			model.addAttribute("customers", customers);
//			return "customers";
//		} else {
//			return "Dashboard";
//		}
//	}
//
//	@GetMapping("/adminDashboard")
//	public String showDashboardPage(HttpServletRequest request, Model model) {
//
//		HttpSession session = request.getSession(false);
//		if (session != null && session.getAttribute("storeName") != null) {
//
//			String storeName = (String) session.getAttribute("storeName");
//			model.addAttribute("storeName", storeName);
//
//			return "adminDashboard";
//		} else {
//
//			return "redirect:/api/adminLogin";
//		}
//	}
//
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request) {
//
//		HttpSession session = request.getSession(false);
//
//		if (session != null) {
//			session.invalidate();
//			System.out.println("Hogya delete");
//		}
//		return "redirect:/api/adminLogin";
//	}
//
//	@RequestMapping(path = "/detail", method = RequestMethod.GET)
//	public String Detail() {
//
//		return "detail";
//	}
//
//	@RequestMapping(value = "/singleCustomer", method = RequestMethod.POST)
//	public String singleCustomersDetails(@RequestParam("id") Long id, HttpSession session, Model model)
//			throws Exception {
//
//		ApiCalls apiCalls = new ApiCalls();
//		String storeName = (String) session.getAttribute("storeName");
//		String password = (String) session.getAttribute("password");
//		apiCalls.setSHOPIFY_STORE_DOMAIN(storeName);
//		apiCalls.setSHOPIFY_TOKKEN(password);
//
//		JSONObject customerJson = services.getDataById("customers", id);
//		System.out.printf("This is the customer in json Format", customerJson);
//
//		if (!Objects.isNull(customerJson)) {
//
//			System.out.println("Here are the customers");
//
//			ShopifyCustomer customer = new Gson().fromJson(customerJson.toString(), SingleCustomer.class).getCustomer();
//			System.out.print(id);
//			System.out.println("Here are the single customer");
//			System.out.println(customer);
//			// System.out.println("Here are the");
//			// System.out.print(id);
//
//			model.addAttribute("customers", customer);
//
//			return "singleCustomer";
//		} else {
//			return "customers";
//		}
//	}
//
//	@RequestMapping(value = "/deleteCustomer", method = RequestMethod.POST)
//	public ModelAndView handleRequest(@RequestParam("id") Long id, HttpSession session, Model model) throws Exception {
//		{
//			ModelAndView modelAndView = new ModelAndView();
//
//			ApiCalls apiCalls = new ApiCalls();
//			String storeName = (String) session.getAttribute("storeName");
//			String password = (String) session.getAttribute("password");
//			apiCalls.setSHOPIFY_STORE_DOMAIN(storeName);
//			apiCalls.setSHOPIFY_TOKKEN(password);
//
//			JSONObject customerJson = services.deleteDataById(id);
//			System.out.printf("This customer has been deleted", customerJson);
//
//			modelAndView.setViewName("redirect:customers");
//			return modelAndView;
//		}
//	}
//
//	@RequestMapping(value = "/createCustomer", method = RequestMethod.POST)
//	public ModelAndView handleRequest(HttpSession session, HttpServletRequest request, Model model) throws Exception {
//		{
//
//			ModelAndView modelAndView = new ModelAndView();
//			ApiCalls apiCalls = new ApiCalls();
//			String storeName = (String) session.getAttribute("storeName");
//			String password = (String) session.getAttribute("password");
//			apiCalls.setSHOPIFY_STORE_DOMAIN(storeName);
//			apiCalls.setSHOPIFY_TOKKEN(password);
//			String first_name = request.getParameter("first_name");
//			String last_name = request.getParameter("last_name");
//			String email = request.getParameter("email");
//
//			long phone = Long.parseLong(request.getParameter("phone"));
//			System.out.println(email);
//			JSONObject customers = new JSONObject();
//			customers.put("customer", new JSONObject().put("first_name", first_name).put("last_name", last_name)
//					.put("email", email).put("phone", phone));
//			System.out.println("customers adding" + customers);
//
//			JSONObject customersJson5 = services.CreateCustomer(customers);
//			Gson gson = new Gson();
//			ShopifyCustomer customer = new Gson().fromJson(customersJson5.toString(), SingleCustomer.class)
//					.getCustomer();
//			System.out.println("nnnnnnbbbbbbbbbbbbbbbbb" + customer);
//			System.out.println(customer.getEmail());
//			System.out.println(customer.getId());
//
//			System.out.printf("This customer has been deleted", customersJson5);
//
//			modelAndView.setViewName("redirect:customers");
//			return modelAndView;
//
//		}
//	}
//
//	@RequestMapping(value = "/updateCustomer", method = RequestMethod.POST)
//	public String updateCustomer(HttpSession session, HttpServletRequest request, Model model,
//			@RequestParam("id") Long customerId) throws Exception {
//		System.out.println("Id is " + customerId);
//		model.addAttribute("id", customerId);
//		return "updateCustomer";
//	}
//
//	@RequestMapping(value = "/updateDataById", method = RequestMethod.POST)
//	public String updatecustomerAction(@RequestParam("customerId") Long customerId, @RequestParam("email") String email,
//			@RequestParam("first_name") String first_name, @RequestParam("last_name") String last_name,
//			@RequestParam("phone") Long phone, HttpSession session, Model model) throws Exception {
//		ApiCalls apiCalls = new ApiCalls();
//		String storeName = (String) session.getAttribute("storeName");
//		String password = (String) session.getAttribute("password");
//		apiCalls.setSHOPIFY_STORE_DOMAIN(storeName);
//		apiCalls.setSHOPIFY_TOKKEN(password);
//		System.out.println("Id again is" + customerId);
//		JSONObject response = services.updateDataById(customerId, email, first_name, last_name, phone);
//		System.out.println(response.toString());
//		if (!Objects.isNull(response)) {
//			ShopifyCustomer customerObject = new Gson().fromJson(response.toString(), SingleCustomer.class)
//					.getCustomer();
//			model.addAttribute("customers", customerObject);
//			return "singleCustomer";
//		} else {
//			return "customers";
//		}
//	}

}
