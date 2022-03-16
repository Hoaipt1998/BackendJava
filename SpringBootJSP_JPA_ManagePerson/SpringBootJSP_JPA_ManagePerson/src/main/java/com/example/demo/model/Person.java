package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


 
@Entity
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String idString;
    private String lastName;
    private String firstName;
    private Gender gender = Gender.Female;
    public Person() {
		super(); 
	}

	public Person(Long id, String idString, String lastName, String firstName) {
		super();
		this.id = id;
		this.idString = idString;
		this.lastName = lastName;
		this.firstName = firstName;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

	public String getIdString() {
		return idString;
	}
	public void setIdString(String idString) {
		this.idString = idString;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Person(String idString, String lastName, String firstName, Gender gender) {
		super();
		this.idString = idString;
		this.lastName = lastName;
		this.firstName = firstName;
		this.gender = gender;
	}
	
}