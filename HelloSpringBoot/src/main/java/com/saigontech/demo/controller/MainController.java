package com.saigontech.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saigontech.demo.model.BMI;

@Controller
public class MainController {
		@Autowired
	    private  BMI myBMI;
		
	 	
		@RequestMapping(value = { "/", "/index", "/hello" }, method = RequestMethod.GET)
	    public String index(Model model) {
	 
	        String message = "Hello Spring Boot + JSTL";
	 
	        model.addAttribute("message", message);
	        model.addAttribute("myBMI",this.myBMI);
	        return "index";
	    }
}
