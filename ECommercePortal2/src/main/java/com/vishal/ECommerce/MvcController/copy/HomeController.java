package com.vishal.ECommerce.MvcController.copy;

import java.io.File;
import java.net.URI;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
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
	
	@RequestMapping("/Register")
	public String Register(Model model){
		return "Register";
	}
	
	@RequestMapping("/Logout")
	public String Logout (HttpServletRequest request){
	request.getSession().invalidate();
		return "Login";
	}
	
	/*@RequestMapping("/ViewProducts/{LoginId}")
	public String ViewProducts(Model model, @PathVariable String LoginId){
		List<ProductsModel> result = productservice.getAllProducts();
		 model.addAttribute("paginationProducts", result);
		 return "ViewProducts";
	}*/
	@RequestMapping("/ViewProducts")
	public String ViewProducts(Model model){
		List<ProductsModel> result = productservice.getAllProducts();
		 model.addAttribute("paginationProducts", result);
		 return "ViewProducts";
	}
	
	/*@RequestMapping("/viewProduct/{Product_Id}")
	public String ViewProduct(Model model, @PathVariable int Product_Id){
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/AllProducts/"+ Product_Id;
	 HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
     ResponseEntity<ProductsModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ProductsModel.class);
     ProductsModel productsmodel = responseEntity.getBody();
		
		 model.addAttribute("paginationProduct", productsmodel);
		 return "viewProduct";
		
	}*/
	
	@RequestMapping("/viewCart/{Product_Id}")
	public String ViewProduct(Model model, @PathVariable int Product_Id){
		HttpHeaders headers = new HttpHeaders();
    	headers.setContentType(MediaType.APPLICATION_JSON);
        RestTemplate restTemplate = new RestTemplate();
	String url = "http://localhost:8080/AllProducts/"+ Product_Id;
	 HttpEntity<String> requestEntity = new HttpEntity<String>(headers);
     ResponseEntity<ProductsModel> responseEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, ProductsModel.class);
     ProductsModel productsmodel = responseEntity.getBody();
		
		 model.addAttribute("paginationProduct", productsmodel);
		 return "viewProduct";
		
	}
	
	
	@RequestMapping("/shoppingCart/{Product_Id}/{login_Id}")
	public String AddCart(Model model,@PathVariable int Product_Id,@PathVariable String login_Id,HttpServletRequest request){
	//	cartservice.AddItemToCart(login_Id, cartitems);
		 return "shoppingCart";
	}
	
	
}
