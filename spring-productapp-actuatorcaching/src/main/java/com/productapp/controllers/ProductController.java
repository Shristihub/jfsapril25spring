package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.ProductDto;
import com.productapp.model.ProductPriceDto;
import com.productapp.service.IProductService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Product Controller", description ="has rest end points of product catalog")
@RequestMapping("/product-api/v1")
// to access the swagger document
//http://localhost:8081/swagger-ui/index.html
public class ProductController {
	
		@Autowired
	    private IProductService productService;
	
//		http://localhost:8081/product-api/v1/products
		@Operation(operationId = "createProduct",
				   summary = "Adding  a product",
				   description = "This restend point is used to create a product")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "201",
						     description="creates a new product",
						     content = @Content(
						    		       mediaType = "application/json",
						    		       schema = @Schema(implementation = ProductDto.class)) )
		})
	    @PostMapping("/products")
		ResponseEntity<Void> addProduct(@RequestBody ProductDto productDto) {
			productService.addProduct(productDto);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		}
	    
//		http://localhost:8081/product-api/v1/products
	    @PutMapping("/products")
		ResponseEntity<Void> updateProduct(@RequestBody ProductDto productDto){
			productService.updateProduct(productDto);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","updating one product");
			headers.add("desc", "update method called");
			return ResponseEntity.status(HttpStatus.ACCEPTED).headers(headers).build();
		}
	    
//		http://localhost:8081/product-api/v1/products
	    @PatchMapping("/products/newprice")
		ResponseEntity<Void> updateProductPrice(@RequestBody ProductPriceDto productPriceDto){
	    	double price = productPriceDto.getPrice();
	    	int productId = productPriceDto.getProductId();
			productService.updateProductPrice(productId, price);
			return ResponseEntity.status(HttpStatus.ACCEPTED).build();
		}
	    
//	    http://localhost:8081/product-api/v1/products/productId/2
	    
	    @DeleteMapping("/products/productId/{productId}")
		ResponseEntity<Void> deleteProduct(@PathVariable int productId){
	    	productService.deleteProduct(productId);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","deleting one product by id");
			return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
	    }
		
//	    http://localhost:8081/product-api/v1/products/productId/1
	    @Operation(operationId = "getProductBy Id",
				   summary = "Getting one product by Id",
				   description = "This restend point is used return a product by id",
				   parameters = {
						   @Parameter(name = "productId",
								      required = true,
								      description = "pass productId")
				   }
				)
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200",
						     description="returns one product",
						     content = @Content(
						    		       mediaType = "application/json",
						    		       schema = @Schema(implementation = ProductDto.class)) )
		})
		@GetMapping("/products/productId/{productId}")
		ResponseEntity<ProductDto> getById(@PathVariable int productId) {
			ProductDto productDto =  productService.getById(productId);
			HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting one product by id");
			return ResponseEntity.ok().headers(headers).body(productDto);
		}
		
//		 http://localhost:8081/product-api/v1/products
		@Operation(operationId = "getAllProducts",
				   summary = "Getting list of products",
				   description = "This rest end point is used to return a list of products")
		@ApiResponses(value = {
				@ApiResponse(responseCode = "200",
						     description=" returns a list of products",
						     content = @Content(
						    		       mediaType = "application/json",
						    		       schema = @Schema(implementation = ProductDto.class)) )
		})
		// add caching
		
		@GetMapping("/products")
		ResponseEntity<List<ProductDto>> getAll(){
			List<ProductDto> productDtos = productService.getAll();
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all products");
			return ResponseEntity.ok().headers(headers).body(productDtos);
		}
		
//		 http://localhost:8081/product-api/v1/products/brand/Samsung
		@GetMapping("/products/brand/{brand}")
		ResponseEntity<List<ProductDto>> getByBrand(@PathVariable String brand){
			List<ProductDto> productDtos = productService.getByBrand(brand);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all products by brand");
			return new ResponseEntity<List<ProductDto>>(productDtos, headers, HttpStatus.OK.value());
		}
//		 http://localhost:8081/product-api/v1/products/category?category=electronics
		@GetMapping("/products/category")
		ResponseEntity<List<ProductDto>> getByCategory(@RequestParam String category){
			List<ProductDto> productDtos = productService.getByCategory(category);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all products by category");
			return ResponseEntity.ok().headers(headers).body(productDtos);
			
		}
//		http://localhost:8081/product-api/v1/products/category/Electronics/price/20000
		@GetMapping("/products/category/{category}/price/{price}")
		ResponseEntity<List<ProductDto>> getByCatLessPrice(@PathVariable String category,@PathVariable double price){
			List<ProductDto> productDtos = productService.getByCatLessPrice(category, price);
	    	HttpHeaders headers =  new HttpHeaders();
			headers.add("info","getting all products by category and less price");
			return ResponseEntity.ok().headers(headers).body(productDtos);
		}

		
		

}
