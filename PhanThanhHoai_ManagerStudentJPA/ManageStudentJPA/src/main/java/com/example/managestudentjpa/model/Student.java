/**
 * 
 */
package com.example.managestudentjpa.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author ThanhHoai
 *
 */
@Entity
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private	String code;
	private	String firstName;
	private	String lastName;
	private	Gender gender=Gender.Male;
	@Column(unique = true)
	private	String email;
	private	Date birthday;
	public Student() {super();}
	
	public Student(int id, String code, String firstName, String lastName, Gender gender, String email, Date birthday) {
		super();
		this.id = id;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.birthday = birthday;
	}
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Student(String code, String firstName, String lastName, Gender gender, String email, Date birthday) {
		super();
	
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.email = email;
		this.birthday = birthday;
	}
	
}
