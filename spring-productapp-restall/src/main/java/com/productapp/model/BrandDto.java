package com.productapp.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BrandDto {
	private Integer brandId;
	private String brandName;
	@ToString.Exclude
	private List<Product> products;
	public BrandDto(String brandName) {
		super();
		this.brandName = brandName;
	}
	
	
	
	

}
