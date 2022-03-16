package com.example.ProductManagementJPA.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ProductManagementJPA.dao.ProductRepository;
import com.example.ProductManagementJPA.model.Product;
import com.example.ProductManagementJPA.model.ProductCategory;

@Service
@Transactional
public class ProductService {
	@Autowired
	private ProductRepository repo;
	
	public List<Product> listAll() {
		return	repo.findAll();
	}

	public Product save(Product product) {
		return repo.save(product);
	}

	public Product get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}
}
