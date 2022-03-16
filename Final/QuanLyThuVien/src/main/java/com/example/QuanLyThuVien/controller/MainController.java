package com.example.QuanLyThuVien.controller;
import org.springframework.stereotype.Controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.QuanLyThuVien.entities.Book;
import com.example.QuanLyThuVien.entities.BorrowReturnBook;
import com.example.QuanLyThuVien.entities.Student;
import com.example.QuanLyThuVien.service.BookService;
import com.example.demo.entities.ChiTietHoaDon;
import com.example.demo.entities.LoaiMonAn;
import com.example.demo.exception.ResourceNotFoundException;




@Controller
public class MainController {
	@Autowired
	private BookService service;
	@RequestMapping(value = { "/book/books" }, method = RequestMethod.GET)
    public String viewBookList(Model model) {
    	List<Book> listbook = service.listAll();
        model.addAttribute("books", listbook);
        return "bookList";
    }
	 @RequestMapping(value = "/addBook")  
	    public String addBook(Model model) {  
	      model.addAttribute("book", new Book());  
	      return "addBook";  
	    }  
	 //add book save
	    @RequestMapping(value = "/save", method = RequestMethod.POST)  
	    public ModelAndView save(Book book) {  
	      service.save(book);
	      return new ModelAndView("redirect:bookList");
	    }  
	    @RequestMapping(value = "/student/addStudent")  
	    public String addStudent(Model model) {  
	      model.addAttribute("student", new Student());  
	      return "addstudent";  
	    }  
	    @RequestMapping(value = "/save", method = RequestMethod.POST)  
	    public ModelAndView save(Student student) {  
	      service.save(student);
	      return new ModelAndView("redirect:studentList");
	    }  
	    @RequestMapping(value = { "/book/getbook/{id}" }, method = RequestMethod.GET)
	    public String viewBookDetail(@PathVariable Integer id) {
	    	List<Book> bookdetails = service.get(id);
	        return "bookdetails";
	    }
	    @RequestMapping(value = "/student/borrowBook", method = RequestMethod.POST)  
	    public ModelAndView save(BorrowReturnBook borrowReturnBook) {  
	      service.save(borrowReturnBook);
	      return new ModelAndView("redirect:borrowReturnBook");
	    }  
		@PutMapping("/student/returnBook")
		 public ModelAndView save(BorrowReturnBook returnBook) {  
		      service.save(returnBook);
		      return new ModelAndView("redirect:borrowReturnBook");
		    }  
		}
