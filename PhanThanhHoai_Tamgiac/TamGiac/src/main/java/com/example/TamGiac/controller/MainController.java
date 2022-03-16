package com.example.TamGiac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.TamGiac.model.TamGiac;

@Controller
public class MainController {
	@Autowired
	private TamGiac tamgiac;

	@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
	public String index(Model model) {

		String message = "Checking the triangle";

		model.addAttribute("message", message);
		model.addAttribute("tamgiac", this.tamgiac);
		return "index";
	}
//	
//	@RequestMapping(value = { "/result"}, method = RequestMethod.GET)
//	public String checkTriangle(Model model) {
//
//		String message = "check";
//
//		model.addAttribute("message", message);
//		return "checkTriangle";
//	}
}
