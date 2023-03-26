package com.credify.RestControllers;
import java.util.Objects;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.credex.services.ServiceLayer;
import com.credify.CustomerData.ShopifyCustomer;
import com.credify.CustomerData.ShopifyCustomersResponse;
import com.google.gson.Gson;

import constant.EndPoint;


@Controller
public class Login {


	@Autowired
	ServiceLayer services;
	@RequestMapping(path = "/adminLogin", method = RequestMethod.GET)
	public String AdminLogin() {

		return "adminLogin";
	}
	
	
	@PostMapping("/adminLogin")
	public String doLogin(HttpServletRequest request, @RequestParam String storeName, @RequestParam String password,
			Model model) throws Exception {
     
		JSONObject jsonObject = services.loginAndGetApiCalls("customers");
		if (!Objects.isNull(jsonObject)&&EndPoint.SHOPIFY_STORE_DOMAIN.equals(storeName)&&EndPoint.SHOPIFY_TOKKEN.equals(password)) {
			ShopifyCustomer[] customers = new Gson().fromJson(jsonObject.toString(), ShopifyCustomersResponse.class)
					.getCustomer();

//			for (ShopifyCustomer custom : customers) {
//				System.out.println(custom);
//			}
//			for (int i = 0; i < customers.length; i++) {
//				System.out.println(customers[i].getId());
//
//			}
//			 System.out.println(jsonObject.toString());

			HttpSession session = request.getSession();
			session.setAttribute("storeName", storeName);
//   session.setAttribute("password", password);
			model.addAttribute("num", customers.length);
			// System.out.println("jsom data" + jsonObject.toString());
			return "adminDashboard";
		} else {
			return "adminLogin";
		}

	}



	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public String Detail() {

		return "detail";
	}
	
}
