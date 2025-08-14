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

import com.productapp.model.BrandDto;
import com.productapp.service.IBrandService;

@RestController
@RequestMapping("/product-api/v1")
public class BrandController {
	
		@Autowired
	    private IBrandService brandService;
	
	
//		http://localhost:8081/product-api/v1/admin/products/brand
	    @PostMapping("/admin/products/brand")
		ResponseEntity<Void> addBrand(@RequestBody BrandDto brandDto) {
			brandService.addBrand(brandDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	    
//		http://localhost:8081/product-api/v1/admin/products/brand
	    @PutMapping("/admin/products/brand")
		ResponseEntity<Void> updateBrand(@RequestBody BrandDto brandDto){
			brandService.updateBrand(brandDto);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","updating one brand");
			headers.add("desc", "update method called");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		}
	    
	    
//	    http://localhost:8081/product-api/v1/admin/products/brandId/2
	    @DeleteMapping("/admin/products/brandId/{brandId}")
		ResponseEntity<Void> deleteBrand(@PathVariable int brandId){
	    	brandService.deleteBrand(brandId);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","deleting one brand by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	    }
		
//	    http://localhost:8081/product-api/v1/admin/products/brandId/1
		@GetMapping("/products/brandId/{brandId}")
		ResponseEntity<BrandDto> getById(@PathVariable int brandId) {
			BrandDto brandDto =  brandService.getById(brandId);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting one brand by id");
			return ResponseEntity.ok().headers(headers).body(brandDto);
		}
		


}
