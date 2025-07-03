package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
//@Table(name= "productDetails") // to a different table name
@NamedQuery(name = "findByCatBrand",query = "from Product p where p.category=?1 and p.brand=?2")
public class Product {
	@Column(length=20)
	private String productName;
	@Id
	@GeneratedValue  // id will be auto generated product_id
	private Integer productId;
	@Column(name="cost")
	private double price;
	@Column(length=30)
	private String category;
	
	private String brand;

	
	
}








