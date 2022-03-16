package com.saigontech.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.saigontech.demo.model.BMI;

@Controller
public class BMIController {
	@RequestMapping(value = "bmi")  
    public String addUser(Model model) {  
      model.addAttribute("bmi", new BMI());  
      return "bmi";  
    }  
    //add person save
    @RequestMapping(value = "showBMI", method = RequestMethod.POST)  
    public String save(Model model, BMI bmi) {  
      model.addAttribute("bmi", bmi);
      return "showBMI";
    }  
}
