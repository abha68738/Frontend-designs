package com.credify.RestControllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.credex.services.ServiceLayer;


@Controller


public class Home {

	
	
	@RequestMapping("/")
	public String defaultPage() throws Exception {
		return "home";
	}
}
