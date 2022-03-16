package com.example.ProductManagementJPA.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProductManagementJPA.dao.ProductCategoryRepository;

import com.example.ProductManagementJPA.model.ProductCategory;

@Service
@Transactional
public class ProductCategoryService {
	@Autowired
	private ProductCategoryRepository repo;

	public List<ProductCategory> listAll() {
		return	repo.findAll();
	}

	public ProductCategory save(ProductCategory productCategory) {
		return repo.save(productCategory);
	}

	public ProductCategory get(Integer id) {
		return repo.findById(id).get();
	}

	public void delete(Integer id) {
		repo.deleteById(id);
	}

}
