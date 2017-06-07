package com.vishal.ECommerce.MvcController.copy;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.apache.catalina.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vishal.ECommerce.Model.Cart_Items;
import com.vishal.ECommerce.Model.ProductsModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Service.Cart_ItemsService;
import com.vishal.ECommerce.Service.ProductsService;
import com.vishal.ECommerce.Service.UserService;


@Controller
@Transactional
public class HomeController extends HttpServlet{
	
	@Autowired
	private ProductsService productservice;
	
	@Autowired
	private Cart_ItemsService cartservice;
	
	@Autowired
	private UserService userservice;
	
	
	

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
	public String WelcomeUser(Model model){
		return "WelcomeUser";
	}
	
	@RequestMapping("/Logout")
	public String Logout (HttpServletRequest request){
	request.getSession().invalidate();
		return "Login";
	}
	
	@RequestMapping("/ViewProducts")
	public String ViewProducts(Model model, String LoginId){
		 List<ProductsModel> result = productservice.getAllProducts();
		 
		 model.addAttribute("paginationProducts", result);
		 return "ViewProducts";
		
	}

	
	@RequestMapping("/shoppingCart")
	public String AddCart(Model model){
	 return "shoppingCart";
	}
	
	
}
