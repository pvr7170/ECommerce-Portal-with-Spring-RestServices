package com.vishal.ECommerce.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vishal.ECommerce.Model.ProductsModel;
import com.vishal.ECommerce.Model.UserModel;
import com.vishal.ECommerce.Service.ProductsService;
import com.vishal.ECommerce.Service.UserService;

@RestController
public class ProductsController{
		
	@Autowired
	private ProductsService productservice;
		
	//---------- Get All Products-----------------------------------
		@RequestMapping(value="/AllProducts", method=RequestMethod.GET)
		public ResponseEntity<List<ProductsModel>> getAllProducts() throws HttpMessageNotWritableException {
			List<ProductsModel> list = productservice.getAllProducts();
			return new ResponseEntity<List<ProductsModel>>(list, HttpStatus.OK);
			      }
		
		//---------- Get Product by ID-----------------------------------
		@RequestMapping(value="/AllProducts/{Product_Id}", method=RequestMethod.GET)
		public ResponseEntity<ProductsModel> getProductById(@PathVariable("Product_Id") int Product_Id) {
			ProductsModel productsmodel =productservice.getProductById(Product_Id);	
			return new ResponseEntity<ProductsModel>(productsmodel, HttpStatus.OK);
		}

		//---------- Add Product by Product_Id-----------------------------------
		@RequestMapping(value="/AllProducts", method=RequestMethod.POST)
		public ResponseEntity<String> updateProduct(@RequestBody ProductsModel productsmodel){
			try {
				productservice.AddProduct(productsmodel);
				return new ResponseEntity<String>("Success",HttpStatus.OK);
			}catch (Exception e) {
				System.out.println("Error Adding product");
				e.printStackTrace();
				}
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		//---------- update Product my style-----------------------------------
		@RequestMapping(value="/AllProducts/{Product_Id}", method=RequestMethod.PUT)
		public ResponseEntity<String> updateProduct(@PathVariable("Product_Id") int Product_Id, @RequestBody ProductsModel productsmodel){
			try {
				productservice.updateProduct(Product_Id, productsmodel);
				return new ResponseEntity<String>("can be Success or failed,check database",HttpStatus.OK);
			}catch (Exception e) {
				System.out.println("Error updating");
				e.printStackTrace();
			}
			return new ResponseEntity<String>("Failed", HttpStatus.NOT_ACCEPTABLE);
		}
		
		//---------- Delete product by Product_Id-----------------------------------
		@RequestMapping(value="/AllProducts/{Product_Id}", method=RequestMethod.DELETE)
		public void DeleteProduct(@PathVariable("Product_Id") int Product_Id){
			productservice.DeleteProduct(Product_Id);
	  }
}
