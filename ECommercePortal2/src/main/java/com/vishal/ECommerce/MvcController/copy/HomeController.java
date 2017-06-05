package com.vishal.ECommerce.MvcController.copy;

import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController extends HttpServlet{
	
	

	private static final long serialVersionUID = 1L;

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
	
	@RequestMapping("/Logout")
	public String Logout (HttpServletRequest request){
	request.getSession().invalidate();
		return "Login";
	}
	
	
	@RequestMapping("/Register")
	public String Register(Map<String,Object> model){
		model.put("message", this.message);
		return "Register";
		
	}
}
