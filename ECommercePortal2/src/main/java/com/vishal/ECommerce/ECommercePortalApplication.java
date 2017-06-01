package com.vishal.ECommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
public class ECommercePortalApplication extends SpringBootServletInitializer {
	
	 protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(ECommercePortalApplication.class);
	    }
	 public static void main(String[] args) {
	
	SpringApplication.run(ECommercePortalApplication.class, args);
	
	}
}
