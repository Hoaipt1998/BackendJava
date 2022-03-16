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
@Table(name = "book")
public class Book{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer book_id;
	@Column(name = "barcode")
	private String barcode;
	@Column(name = "title")
	private String title;
	@Column(name = "author")
	private String author;	
	@Column(name = "description")
	private String description;
	public Book(Integer book_id, String barcode, String title, String author, String description, double price,
			List<BorrowReturnBook> borrowReturnBook) {
		super();
		this.book_id = book_id;
		this.barcode = barcode;
		this.title = title;
		this.author = author;
		this.description = description;
		this.price = price;
		this.borrowReturnBook = borrowReturnBook;
	}

	

	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Integer getBook_id() {
		return book_id;
	}

	public void setBook_id(Integer book_id) {
		this.book_id = book_id;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public List<BorrowReturnBook> getBorrowReturnBook() {
		return borrowReturnBook;
	}

	public void setBorrowReturnBook(List<BorrowReturnBook> borrowReturnBook) {
		this.borrowReturnBook = borrowReturnBook;
	}

	@Column(name = "price")
	private double price;
	
	@OneToMany(mappedBy = "book")
	private List<BorrowReturnBook> borrowReturnBook;
	
	
}