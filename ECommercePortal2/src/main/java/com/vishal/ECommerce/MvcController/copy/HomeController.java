package com.vishal.ECommerce.MvcController.copy;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {

private String message = "Welcome to ECommerce Shopping Portal";
	
	@RequestMapping("/welcome")
	public String welcome(Map<String,Object> model){
		model.put("message", this.message);
		return "welcome";
		
	}
	
	@RequestMapping("/Login")
	public String Login(Map<String,Object> model){
		model.put("message", this.message);
		return "Login";
		
	}
	
	@RequestMapping("/WelcomeUser")
	public String WelcomeUser(Map<String,Object> model){
		model.put("message", this.message);
		return "WelcomeUser";
	}
	
	
	@RequestMapping("/Register")
	public String Register(Map<String,Object> model){
		model.put("message", this.message);
		return "Register";
		
	}
}
