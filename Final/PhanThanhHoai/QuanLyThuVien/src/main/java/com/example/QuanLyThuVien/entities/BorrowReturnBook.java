package com.example.QuanLyThuVien.entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="borrowReturnBook")
public class BorrowReturnBook {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "borrowDate")
	private Date borrowDate;
	@Column(name = "returnDate")
	private Date returnDate;
	@Column(name = "note")
	private String note;
	
	@ManyToOne
	@JoinColumn(name="Borrow_Book")
	private Book book;
	@ManyToOne
	@JoinColumn(name="Borrow_Student")
	private Student student;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getBorrowDate() {
		return borrowDate;
	}
	public void setBorrowDate(Date borrowDate) {
		this.borrowDate = borrowDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public BorrowReturnBook(Integer id, Date borrowDate, Date returnDate, String note, Book book, Student student) {
		super();
		this.id = id;
		this.borrowDate = borrowDate;
		this.returnDate = returnDate;
		this.note = note;
		this.book = book;
		this.student = student;
	}


}
