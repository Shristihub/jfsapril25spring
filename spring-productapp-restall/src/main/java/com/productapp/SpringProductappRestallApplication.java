package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.BrandDto;
import com.productapp.model.CategoryDto;
import com.productapp.service.IBrandService;
import com.productapp.service.ICategoryService;

@SpringBootApplication
public class SpringProductappRestallApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappRestallApplication.class, args);
	}

	@Autowired
	private IBrandService brandService;
	
	@Autowired
	private ICategoryService categoryService;
	@Override
	public void run(String... args) throws Exception {
//		BrandDto brandDto =  new BrandDto("Samsung");
//		brandService.addBrand(brandDto);
//		brandDto =  new BrandDto("Adidas");
//		brandService.addBrand(brandDto);
//		brandDto =  new BrandDto("Dell");
//		brandService.addBrand(brandDto);
//		brandDto =  new BrandDto("Lavie");
//		brandService.addBrand(brandDto);
//		
//		CategoryDto categoryDto =  new CategoryDto("Electronics");
//		categoryService.addCategory(categoryDto);
//		categoryDto =  new CategoryDto("Sports");
//		categoryService.addCategory(categoryDto);
//		categoryDto =  new CategoryDto("Bags");
//		categoryService.addCategory(categoryDto);
		
	}

}
