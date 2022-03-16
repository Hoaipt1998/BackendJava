package com.example.demo.controller;
import com.example.demo.model.*;
import com.example.demo.service.PersonService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    
	@Autowired
	private PersonService service;
	
    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {
        String message = "Hello Spring Boot + JSP + JPA + Manage Person";
 
        model.addAttribute("message", message);
        return "index";
    }
 
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
    	List<Person> listPeople = service.listAll();
        model.addAttribute("persons", listPeople);
        return "personList";
    }
    
    @RequestMapping(value = "addPerson")  
    public String addUser(Model model) {  
      model.addAttribute("person", new Person());  
      return "addPerson";  
    }  
    //add person save
    @RequestMapping(value = "save", method = RequestMethod.POST)  
    public ModelAndView save(Person person) {  
      service.save(person);
      return new ModelAndView("redirect:personList");
    }  
    
  //delete person
    @RequestMapping("deletePerson")
    public ModelAndView deleteEmployee(@RequestParam Long id) {
        service.delete(id);
        return new ModelAndView("redirect:personList");
    }
    //edit person
    @RequestMapping("editPerson")
    public ModelAndView editEmployee(@RequestParam Long id, @ModelAttribute Person person) {
        person = service.get(id);
        return new ModelAndView("editPersonForm", "person", person);
    }
    
    @RequestMapping("editPersonSave")
    public ModelAndView saveEmployee(@ModelAttribute Person person) {
    	service.save(person);
        return new ModelAndView("redirect:personList");
    }
    
  
}
