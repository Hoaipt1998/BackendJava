package com.example.ProductManagementJPA.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer p_id;

	private String p_name;

	private Double p_price;
	private Date p_createDate;
	private String p_image;
	private Status p_status;

	@ManyToOne
	@JoinColumn
	private ProductCategory productcategory;

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public Double getP_price() {
		return p_price;
	}

	public void setP_price(Double p_price) {
		this.p_price = p_price;
	}

	public Date getP_createDate() {
		return p_createDate;
	}

	public void setP_createDate(Date p_createDate) {
		this.p_createDate = p_createDate;
	}

	public String getP_image() {
		return p_image;
	}

	public void setP_image(String p_image) {
		this.p_image = p_image;
	}

	public Status getP_status() {
		return p_status;
	}

	public void setP_status(Status p_status) {
		this.p_status = p_status;
	}

	public ProductCategory getProductcategory() {
		return productcategory;
	}

	public void setProductcategory(ProductCategory productcategory) {
		this.productcategory = productcategory;
	}

	public Product(Integer p_id, String p_name, Double p_price, Date p_createDate, String p_image, Status p_status,
			ProductCategory productcategory) {
		super();
		this.p_id = p_id;
		this.p_name = p_name;
		this.p_price = p_price;
		this.p_createDate = p_createDate;
		this.p_image = p_image;
		this.p_status = p_status;
		this.productcategory = productcategory;
	}

	
}
