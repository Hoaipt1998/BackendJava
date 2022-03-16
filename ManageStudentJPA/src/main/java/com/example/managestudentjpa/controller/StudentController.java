/**
 * 
 */
package com.example.managestudentjpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.managestudentjpa.model.Student;
import com.example.managestudentjpa.service.StudentService;

/**
 * @author ThanhHoai
 *
 */
@Controller
public class StudentController {
	@Autowired
	private StudentService service;
	@RequestMapping(value = { "/", "/listStudent" }, method = RequestMethod.GET)
    public String index(Model model) {
		List<Student> listStudent = service.listAll();
        model.addAttribute("students", listStudent);
        return "listStudent";
    }
	
	@RequestMapping(value = "addStudent")  
    public String addUser(Model model) {  
      model.addAttribute("student", new Student());  
      return "addStudent";  
    }  
    //add student save
    @RequestMapping(value = "saveStudent", method = RequestMethod.POST)  
    public ModelAndView save(Student student) {  
      service.save(student);
      return new ModelAndView("redirect:listStudent");
    }  
    //delete student
    @RequestMapping("deleteStudent")
    public ModelAndView deleteEmployee(@RequestParam int id) {
        service.delete(id);
        return new ModelAndView("redirect:listStudent");
    }
    //edit student
    @RequestMapping("editStudent")
    public ModelAndView updateStudent(@RequestParam int id, @ModelAttribute Student student) {
        student = service.get(id);
        return new ModelAndView("editStudent", "student", student);
    }
    @RequestMapping("editStudentSave")
    public ModelAndView saveStudent(@ModelAttribute Student student) {
    	service.save(student);
        return new ModelAndView("redirect:listStudent");
    }
}
