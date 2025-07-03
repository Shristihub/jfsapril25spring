package com.productapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.exception.ProductNotFoundException;
import com.productapp.model.Product;
import com.productapp.model.ProductDto;
import com.productapp.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ModelMapper mapper;

	// autowire IProductRepository
	private IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public void addProduct(ProductDto productDto) {
		// convert dto(productDto) in entity(product)
		Product product = mapper.map(productDto, Product.class);
		// save the entity
		// check for id -
//		if no, autogenerate the id, create a new row
//		if yes, check if id is in database, 
//		 if no, create a new row, if yes update the row
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
		List<Product> products = productRepository.findByBrand(brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("brand not found");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCategory(String category) throws ProductNotFoundException {
		List<Product> products = productRepository.queryByCategory(category);
		if (products.isEmpty())
			throw new ProductNotFoundException("category not found");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCatLessPrice(String category, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCategoryAndPriceLessThanEqual(category, price);
		if (products.isEmpty())
			throw new ProductNotFoundException("products with this category & with less price not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCatNameContains(String category, String productName) throws ProductNotFoundException {
		List<Product> products = productRepository.findByCatProductName(category, "%"+productName+"%");
		if (products.isEmpty())
			throw new ProductNotFoundException("products with this category & with name not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByBrandPrice(String brand, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.findByBrandPrice(brand, price);
		if (products.isEmpty())
			throw new ProductNotFoundException("products with this brand & with less price not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCatBrand(String category, String brand) {
		List<Product> products = productRepository.printByCatBrand(category, brand);
		if (products.isEmpty())
			throw new ProductNotFoundException("products with this brand & category not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

	@Override
	public List<ProductDto> getByCatPrice(String category, double price) throws ProductNotFoundException {
		List<Product> products = productRepository.getByCatPrice(category,price);
		if (products.isEmpty())
			throw new ProductNotFoundException("products with this category & with less price not available");
		return products.stream().map(product -> mapper.map(product, ProductDto.class)).collect(Collectors.toList());
	}

}



