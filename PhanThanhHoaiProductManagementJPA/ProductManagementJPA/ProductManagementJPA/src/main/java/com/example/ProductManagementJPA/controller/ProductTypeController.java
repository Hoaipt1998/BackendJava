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
import com.example.ProductManagementJPA.exception.ResourceNotFoundException;
import com.example.ProductManagementJPA.model.ProductCategory;

@Controller
@RequestMapping("/api/v1/")
public class ProductTypeController {
	@Autowired
	private ProductCategoryRepository repo;
	
	@GetMapping("/productcategories")
	public List<ProductCategory> getAll(){
		return repo.findAll();
	}
	
	@PostMapping("/productcategories")
	public ProductCategory createLoaiMonAn(@RequestBody ProductCategory productCategory) {
		return repo.save(productCategory);
	}

	
	@GetMapping("/productcategories/{id}")
	public ResponseEntity<ProductCategory> getLoaiMonAn(@PathVariable Integer id){
		ProductCategory object = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Category khong ton tai with: " + id));
		return ResponseEntity.ok(object);
	}
	
	@PutMapping("/productcategories/{id}")
	public ResponseEntity<ProductCategory> updateLoaiMonAn(@PathVariable Integer id, @RequestBody ProductCategory productCategoryDetail){
		ProductCategory object =repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Category khong ton tai with: " + id));
		object.setPc_name(productCategoryDetail.getPc_name());
		ProductCategory productCategory = repo.save(object);
		return ResponseEntity.ok(productCategory);
	}
	
	@DeleteMapping("/productcategories/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteLoaiMonAn(@PathVariable Integer id){
		ProductCategory productCategory = repo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Product Category khong ton tai with: " + id));
		repo.delete(productCategory);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	
}
