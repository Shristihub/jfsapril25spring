package com.productapp.service;

import com.productapp.exceptions.BrandNotFoundException;
import com.productapp.model.BrandDto;

public interface IBrandService {
	
	//CRUD operation
	void addBrand(BrandDto brandDto);
	void updateBrand(BrandDto brandDto);
	void deleteBrand(int brandId);
	BrandDto getById(int brandId) throws BrandNotFoundException;
	

}









