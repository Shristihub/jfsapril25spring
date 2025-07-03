package com.productapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.productapp.model.ProductDto;
import com.productapp.service.IProductService;

@SpringBootApplication
public class SpringProductappJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringProductappJpaApplication.class, args);
	}
	
	@Autowired
	private IProductService productService;

	@Override
	public void run(String... args) throws Exception {
		
		// create a productdto object
		ProductDto productDto =  new ProductDto("Mobile", null, 20000, "Electronics","Samsung");
		//call the method of service layer;
//		productService.addProduct(productDto);
		productDto =  new ProductDto("Ear Phones", null, 76000, "Electronics","Boat");
//		productService.addProduct(productDto);
		productDto =  new ProductDto("Toy Phones", null, 3200, "Electronics","Samsung");
//		productService.addProduct(productDto);
//		productDto =  new ProductDto("Shoes", null, 3400, "Sports","Nike");
//		productService.addProduct(productDto);
//		productDto =  new ProductDto("Jacket", null, 5600, "Sports","Adidas");
//		productService.addProduct(productDto);
		
//		System.out.println();
//		System.out.println("Get all products");
//		productService.getAll().forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Get By Id");
//		
//		ProductDto nproductDto = productService.getById(1);
//		System.out.println(nproductDto);
//		
//		//update- call setter methods
//		nproductDto.setPrice(30000);
//		productService.updateProduct(nproductDto);
//		
//		System.out.println();
//		System.out.println("Get By Id");
//		nproductDto = productService.getById(1);
//		System.out.println(nproductDto);
		
//		System.out.println();
//		System.out.println("Get By brand");
//		productService.getByBrand("Samsung").stream().forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Get By category");
//		productService.getByCategory("Sports").stream().forEach(System.out::println);
//		
//		System.out.println();
//		System.out.println("Get By category & Less Price");
//		productService.getByCatLessPrice("Electronics",40000).stream().forEach(System.out::println);
//		
		System.out.println();
		System.out.println("Custom - Get By category with name contains");
		productService.getByCatNameContains("Electronics","Phones").stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Custom - Get By brand and less price");
		productService.getByBrandPrice("Samsung",8000).stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Named Query - Get By category and brand");
		productService.getByCatBrand("Electronics", "Dell").stream().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Native Query - Get By category with less price");
		productService.getByCatLessPrice("Sports", 9000).stream().forEach(System.out::println);
		
	}

}
