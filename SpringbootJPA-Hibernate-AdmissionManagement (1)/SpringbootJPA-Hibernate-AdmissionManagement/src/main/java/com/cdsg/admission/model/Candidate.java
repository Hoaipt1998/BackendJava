package com.cdsg.admission.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "candidates")
public class Candidate {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 25 , nullable = false)
	private String lastName;
	@Column(length = 10 , nullable = false)
	private String firstName;
	@Column(length = 15)
	private String birthday;
	@Column(length = 50 , nullable = false , unique = true)
	private String phone;
	@Column(length = 30 , unique = true)
	private String email;
	@Column(length = 10)
	private String gender;
	@Column(length = 50)
	private String permanentAddress;
	@Column(length = 50 , nullable = false)
	private String contactAddress;
	
	@OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
	private List<Exam> exam = new ArrayList<Exam>();
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Major major;
	
	@ManyToOne(fetch = FetchType.LAZY)
	private Grade grade;

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	public Candidate(String lastName, String firstName, String birthday, String phone, String email, String gender,
			String permanentAddress, String contactAddress, Major major, Grade grade) {
		super();
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.permanentAddress = permanentAddress;
		this.contactAddress = contactAddress;
		this.major = major;
		this.grade = grade;
	}

	public Candidate(Integer id, String lastName, String firstName, String birthday, String phone, String email,
			String gender, String permanentAddress, String contactAddress, List<Exam> exam , Major major,Grade grade) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.firstName = firstName;
		this.birthday = birthday;
		this.phone = phone;
		this.email = email;
		this.gender = gender;
		this.permanentAddress = permanentAddress;
		this.contactAddress = contactAddress;
		this.exam = exam;
		this.major = major;
		this.grade = grade;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Candidate() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getPermanentAddress() {
		return permanentAddress;
	}

	public void setPermanentAddress(String permanentAddress) {
		this.permanentAddress = permanentAddress;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public List<Exam> getExam() {
		return exam;
	}

	public void setExam(List<Exam> exam) {
		this.exam = exam;
	}
	
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " Major: " + 
				this.major.getName() + " Grade: " + this.grade.getName();
	}
	
}
