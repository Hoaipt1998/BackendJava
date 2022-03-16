package com.example.ProductManagementJPA.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ProductManagementJPA.model.ProductCategory;

@Repository
public interface ProductCategoryRepository extends JpaRepository<ProductCategory, Integer> {
	List<ProductCategory> findAll();
}
