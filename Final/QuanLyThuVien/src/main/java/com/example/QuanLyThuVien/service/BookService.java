package com.example.QuanLyThuVien.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.QuanLyThuVien.dao.BookRepository;
import com.example.QuanLyThuVien.entities.Book;


@Service
@Transactional
public class BookService {
	 @Autowired
	 private BookRepository repo;
	 public List<Book> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Book book) {
	        repo.save(book);
	    }
	     
	    public Book get(Integer id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(Integer id) {
	        repo.deleteById(id);
	    }
	    

}
