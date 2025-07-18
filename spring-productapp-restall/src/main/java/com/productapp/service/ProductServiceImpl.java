package com.productapp.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exceptions.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {
	
	@Autowired
	private IProductRepository productRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public void addProduct(ProductDto productDto) {
		// convert dto(productDto) in entity(product)
		Product product = mapper.map(productDto, Product.class);
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		// convert dto(productDto) in entity(product)
		Product product = mapper.map(productDto, Product.class);
		// product should have id in it - then updates it
		productRepository.save(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public ProductDto getById(int productId) {
//		Optional<Product> productOpt =  productRepository.findById(productId);
//		//check if opt is having value product entity
//		if(productOpt.isPresent()) {
//			// this returns the product entity
//			Product product = productOpt.get();
//			//convert the entity into productDto object
//			ProductDto productDto =mapper.map(product, ProductDto.class);
//			return productDto;
//		}
//		return null;
		// get the value if present or throw exception
		Product product = productRepository.findById(productId)
				.orElseThrow(() -> new ProductNotFoundException("invalid id"));
		// convert the entity into productDto object
		ProductDto productDto = mapper.map(product, ProductDto.class);
		return productDto;

	}

	@Override
	public List<ProductDto> getAll() {
		List<Product> products = productRepository.findAll();
		return products.stream().map(product -> mapper.map(product, ProductDto.class))
						 .sorted((p1,p2)->p1.getProductName().compareTo(p2.getProductName()))
				         .collect(Collectors.toList());

	}

	@Override
	public List<ProductDto> getByBrand(String brand) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByCategory(String category) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductDto> getByCatLessPrice(String category, double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
