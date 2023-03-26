package com.credify.RestControllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.credex.services.ServiceLayer;
@Controller
public class Dashboard {
	@Autowired
	ServiceLayer services;
	
	
	@GetMapping("/adminDashboard")
	public String showDashboardPage(HttpServletRequest request, Model model) {

		HttpSession session = request.getSession(false);
		if (session != null && session.getAttribute("storeName") != null) {

			String storeName = (String) session.getAttribute("storeName");
			model.addAttribute("storeName", storeName);

			return "adminDashboard";
		} else {

			return "redirect:/api/adminLogin";
		}
	}
}
