/**
 * 
 */
package com.example.managestudentjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.managestudentjpa.dao.StudentRepository;
import com.example.managestudentjpa.model.Student;



/**
 * @author ThanhNhan
 *
 */
@Service
@Transactional//làm việc với csdl, nằm trong phiên làm việc
public class StudentService {
	   @Autowired
	    private StudentRepository repo;
	     
	    public List<Student> listAll() {
	        return repo.findAll();
	    }
	     
	    public void save(Student student) {
	        repo.save(student);
	    }
	     
	    public Student get(int id) {
	        return repo.findById(id).get();
	    }
	     
	    public void delete(int id) {
	        repo.deleteById(id);
	    }
}

