package com.example.ProductManagementJPA.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.ProductManagementJPA.dao.ProductCategoryRepository;
import com.example.ProductManagementJPA.dao.ProductRepository;
import com.example.ProductManagementJPA.exception.ResourceNotFoundException;
import com.example.ProductManagementJPA.model.Product;
import com.example.ProductManagementJPA.model.ProductCategory;

@Controller
@RequestMapping("/api/v1/")
public class ProductController {
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/products")
	public List<Product> getAll(){
		return repo.findAll();
	}
	
	@PostMapping("/products")
	public Product createLoaiMonAn(@RequestBody Product product) {
		return repo.save(product);
	}

	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getLoaiMonAn(@PathVariable Integer id){
		Product object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product khong ton tai with: " + id));
		return ResponseEntity.ok(object);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateLoaiMonAn(@PathVariable Integer id, @RequestBody Product productDetail){
		Product object =repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product  khong ton tai with: " + id));
		object.setP_name(productDetail.getP_name());
		object.setP_createDate(productDetail.getP_createDate());
		object.setP_price(productDetail.getP_price());
		object.setP_status(productDetail.getP_status());
		
		Product product = repo.save(object);
		return ResponseEntity.ok(product);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLoaiMonAn(@PathVariable Integer id){
		Product loaiMonAn = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product  khong ton tai with: " + id));
		repo.delete(loaiMonAn);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
}
