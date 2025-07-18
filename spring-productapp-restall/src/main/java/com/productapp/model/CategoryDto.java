package com.productapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CategoryDto {
	private Integer categoryId;
	private String categoryName;
	@ToString.Exclude
	private List<Product> products;
	public CategoryDto(String categoryName) {
		super();
		this.categoryName = categoryName;
	}
	
	

}
