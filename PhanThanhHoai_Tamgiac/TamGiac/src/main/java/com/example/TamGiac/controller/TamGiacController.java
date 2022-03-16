package com.example.TamGiac.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.TamGiac.model.TamGiac;

@Controller
public class TamGiacController {

	@RequestMapping(value = "index")
	public String addUser(Model model) {
		model.addAttribute("tamgiac", new TamGiac());
		return "index";
	}

	@RequestMapping(value = "showResult", method = RequestMethod.POST)
	public String save(Model model, TamGiac tamgiac) {
		String msg =" ";
		if(tamgiac.getTamGiac()==0) {
			msg="This is not a triangle";
		} else if(tamgiac.getTamGiac()==1) {
			msg="This is an equilateral triangle";
		} else if(tamgiac.getTamGiac()==2) {
			msg="This is an isosceles triangle";
		} else if(tamgiac.getTamGiac()==3) {
			msg="This is an isosceles and perpendicular triangle";
		} else if(tamgiac.getTamGiac()==4) {
			msg="This is a perpendicular triangle";
		} else msg="This is a triangle";
		model.addAttribute("tamgiac", tamgiac);
		model.addAttribute("msg", msg);
		return "showResult";
	}

}
