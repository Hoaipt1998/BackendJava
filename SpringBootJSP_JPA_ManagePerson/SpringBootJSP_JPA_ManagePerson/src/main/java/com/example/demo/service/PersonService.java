package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.PersonRepository;
import com.example.demo.model.Person;
 
@Service
@Transactional
public class PersonService {
 
    @Autowired
    private PersonRepository repo;
     
    public List<Person> listAll() {
        return repo.findAll();
    }
     
    public void save(Person person) {
        repo.save(person);
    }
     
    public Person get(long id) {
        return repo.findById(id).get();
    }
     
    public void delete(long id) {
        repo.deleteById(id);
    }
}