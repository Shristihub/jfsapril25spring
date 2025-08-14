package com.productapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.CategoryDto;
import com.productapp.service.ICategoryService;


@RestController
@RequestMapping("/product-api/v1")
public class CategoryController {
	
		@Autowired
	    private ICategoryService categoryService;
	
	
//		http://localhost:8081/product-api/v1/admin/products/category
	    @PostMapping("/admin/products/category")
		ResponseEntity<Void> addCategory(@RequestBody CategoryDto categoryDto) {
			categoryService.addCategory(categoryDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	    
//		http://localhost:8081/product-api/v1/admin/products/category
	    @PutMapping("/admin/products/category")
		ResponseEntity<Void> updateCategory(@RequestBody CategoryDto categoryDto){
			categoryService.updateCategory(categoryDto);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","updating one category");
			headers.add("desc", "update method called");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		}
	    
	    
//	    http://localhost:8081/product-api/v1/admin/products/categoryId/2
	    @DeleteMapping("/admin/products/categoryId/{categoryId}")
		ResponseEntity<Void> deleteCategory(@PathVariable int categoryId){
	    	categoryService.deleteCategory(categoryId);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","deleting one category by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	    }
		
//	    http://localhost:8081/product-api/v1/admin/products/categoryId/1
		@GetMapping("/products/categoryId/{categoryId}")
		ResponseEntity<CategoryDto> getById(@PathVariable int categoryId) {
			CategoryDto categoryDto =  categoryService.getById(categoryId);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting one category by id");
			return ResponseEntity.ok().headers(headers).body(categoryDto);
		}
		
		

}
