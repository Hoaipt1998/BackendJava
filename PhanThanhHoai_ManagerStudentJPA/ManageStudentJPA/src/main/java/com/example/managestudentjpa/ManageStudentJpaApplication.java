package com.example.managestudentjpa;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import com.example.managestudentjpa.model.Gender;
import com.example.managestudentjpa.model.Student;
import com.example.managestudentjpa.service.StudentService;


@SpringBootApplication
@EnableAutoConfiguration(exclude = {
 ErrorMvcAutoConfiguration.class
})
public class ManageStudentJpaApplication  implements CommandLineRunner{
	@Autowired
	private StudentService studentService;
	public static void main(String[] args){
		SpringApplication.run(ManageStudentJpaApplication.class, args);
	}
	@Override
	public void run(String... args) {
		 studentService.save(new Student("17110198", "Nguyen Thanh", "Nhan", Gender.Male,"nhan@gmail.com",Date.valueOf("1999-05-29")));
	}
}
