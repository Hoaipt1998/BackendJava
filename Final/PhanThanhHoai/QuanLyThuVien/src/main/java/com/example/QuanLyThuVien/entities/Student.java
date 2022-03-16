package com.example.QuanLyThuVien.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(unique = true, name = "code")
	private String code;
	@Column (name = "firstName")
	private String firstName;
	@Column (name = "lastName")
	private String lastName;
	@Column (name = "phone")
	private String phone;
	@Column (name = "email")
	private String email;
	
	@OneToMany(mappedBy = "student")
	private List<BorrowReturnBook> borrowReturnBook;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public List<BorrowReturnBook> getBorrowReturnBook() {
		return borrowReturnBook;
	}

	public Student(Integer id, String code, String firstName, String lastName, String phone, String email,
			List<BorrowReturnBook> borrowReturnBook) {
		super();
		this.id = id;
		this.code = code;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.borrowReturnBook = borrowReturnBook;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public void setBorrowReturnBook(List<BorrowReturnBook> borrowReturnBook) {
		this.borrowReturnBook = borrowReturnBook;
	}
	
}
