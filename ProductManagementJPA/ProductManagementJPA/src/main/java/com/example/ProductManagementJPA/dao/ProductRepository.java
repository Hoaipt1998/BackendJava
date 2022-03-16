package com.example.ProductManagementJPA.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.ProductManagementJPA.model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
