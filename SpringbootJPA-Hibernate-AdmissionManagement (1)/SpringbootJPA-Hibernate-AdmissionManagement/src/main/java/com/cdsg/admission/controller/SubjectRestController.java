package com.cdsg.admission.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.cdsg.admission.model.Subject;
import com.cdsg.admission.service.SubjectService;

@RestController
@RequestMapping(path = "/subject")
public class SubjectRestController {
	@Autowired
	SubjectService subjectService;
	@GetMapping("")
    public List<Subject> getSubjects() 
    {
        return subjectService.listAll();
    }
     
    @PostMapping(path= "/", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Object> addEmployee(@RequestBody Subject subject) 
    {
    	subjectService.save(subject);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                                    .path("/{id}")
                                    .buildAndExpand(subject.getId())
                                    .toUri();
         
        return ResponseEntity.created(location).build();
    }
}
