package com.example.ProductManagementJPA.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "productcategory")
public class ProductCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pc_id;

	private String pc_name;

	@OneToMany(mappedBy =  "productcategory", cascade = CascadeType.ALL)
	private List<Product> listProducts;
	
	public ProductCategory() {
		super();
	}

	public ProductCategory(Integer pC_id, String pC_name) {
		super();
		pc_id = pC_id;
		pc_name = pC_name;
	}


	public Integer getPc_id() {
		return pc_id;
	}

	public void setPc_id(Integer pc_id) {
		this.pc_id = pc_id;
	}

	public String getPc_name() {
		return pc_name;
	}

	public void setPc_name(String pc_name) {
		this.pc_name = pc_name;
	}

	public List<Product> getListProducts() {
		return listProducts;
	}

	public void setListProducts(List<Product> listProducts) {
		this.listProducts = listProducts;
	} 
	
	

}
