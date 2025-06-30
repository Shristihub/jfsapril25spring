package com.productapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService{
	
	@Autowired
	private ModelMapper mapper;
	
	//autowire IProductRepository
	private IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		//convert dto(productDto) in entity(product)
		Product product = mapper.map(productDto, Product.class);
		//save the entity
		// check for id - 
//		if no, autogenerate the id, create a new row
//		if yes, check if id is in database, 
//		 if no, create a new row, if yes update the row
		productRepository.save(product);
	}

	@Override
	public void updateProduct(ProductDto productDto) {
		//convert dto(productDto) in entity(product)
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
		Optional<Product> productOpt =  productRepository.findById(productId);
		//check if opt is having value product entity
		if(productOpt.isPresent()) {
			// this returns the product entity
			Product product = productOpt.get();
			//convert the entity into productDto object
			ProductDto productDto =mapper.map(product, ProductDto.class);
			return productDto;
		}
		return null;
	}

	@Override
	public List<ProductDto> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
