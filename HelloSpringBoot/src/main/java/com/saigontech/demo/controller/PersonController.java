package com.saigontech.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.saigontech.demo.model.Person;

@Controller
public class PersonController {
    private static List<Person> persons = new ArrayList<Person>();
    
    static {
        persons.add(new Person("P001", "Bill", "Gates"));
        persons.add(new Person("P002", "Steve", "Jobs"));
    }
 
  
    @RequestMapping(value = { "/personList" }, method = RequestMethod.GET)
    public String viewPersonList(Model model) {
 
        model.addAttribute("persons", persons);
 
        return "personList";
    }
    
    @RequestMapping(value = "addPerson")  
    public String addUser(Model model) {  
      model.addAttribute("person", new Person());  
      return "addPerson";  
    }  
    //add person save
    @RequestMapping(value = "savePerson", method = RequestMethod.POST)  
    public ModelAndView save(Person person) {  
      persons.add(person);
      System.out.println(person.getID() + "-" + person.getFirstName() + "-" 
    		  			+person.getLastName());
      return new ModelAndView("redirect:personList");
    }  
    
  //delete person
    @RequestMapping("deletePerson")
    public ModelAndView deleteEmployee(@RequestParam String id) {
        for(int i = 0; i<persons.size(); i++) {
        	if(persons.get(i).getID().contentEquals(id))
        		persons.remove(i);
        }
        return new ModelAndView("redirect:personList");
    }
    //edit person
    @RequestMapping("editPerson")
    public ModelAndView editEmployee(@RequestParam String id, @ModelAttribute Person person) {
        person = this.getPersonByID(id);
        return new ModelAndView("editPersonForm", "person", person);
    }
    
    @RequestMapping("editPersonSave")
    public ModelAndView saveEmployee(@ModelAttribute Person person) {
    	for(int i = 0; i<persons.size(); i++) {
        	if(persons.get(i).getID().contentEquals(person.getID())) {
        		persons.set(i, person);
        		break;
        	}
        }
        return new ModelAndView("redirect:personList");
    }
    
    public Person getPersonByID(String id) {
    	Person p = null;
    	for(int i = 0; i<persons.size(); i++) {
        	if(persons.get(i).getID().contentEquals(id)) {
        		p = persons.get(i);
        		break;
        	}
        }
    	return p;
    }
}
