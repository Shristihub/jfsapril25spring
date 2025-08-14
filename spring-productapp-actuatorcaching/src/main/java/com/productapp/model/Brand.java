package com.productapp.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Brand {
	@Id
	@GeneratedValue(generator = "brand_gen", strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "brand_gen",sequenceName = "brand_seq", initialValue = 101,allocationSize = 1)
	private Integer brandId;
	private String brandName;
	
	@OneToMany(mappedBy = "brand")
	@ToString.Exclude
	@JsonIgnore
	private List<Product> products;
	
	

}
