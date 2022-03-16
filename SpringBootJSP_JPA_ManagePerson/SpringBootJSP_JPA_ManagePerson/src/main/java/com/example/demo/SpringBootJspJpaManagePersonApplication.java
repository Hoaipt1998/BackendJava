package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.model.Gender;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;

@SpringBootApplication
public class SpringBootJspJpaManagePersonApplication implements CommandLineRunner{
	@Autowired
	private PersonService personService;
	public static void main(String[] args) {
		SpringApplication.run(SpringBootJspJpaManagePersonApplication.class, args);
		System.out.println("Welcome Spring Data Manage Person");
		
	}
	@Override
	public void run(String... args) {
		 personService.save(new Person("009", "Tuoi", "Nguyen", Gender.Male));
		 
	}
	 

}
