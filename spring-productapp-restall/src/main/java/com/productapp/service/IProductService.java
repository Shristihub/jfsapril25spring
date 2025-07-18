package com.productapp.service;

import java.util.List;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.ProductDto;

public interface IProductService {
	
	//CRUD operation
	void addProduct(ProductDto productDto);
	void updateProduct(ProductDto productDto);
	void deleteProduct(int productId);
	ProductDto getById(int productId) throws ProductNotFoundException;
	List<ProductDto> getAll();
	
	//Derived Queries
	List<ProductDto> getByBrand(String brand)throws ProductNotFoundException;
	List<ProductDto> getByCategory(String category)throws ProductNotFoundException;
	List<ProductDto> getByCatLessPrice(String category,double price)throws ProductNotFoundException;

}









