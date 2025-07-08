package com.restaurantapp.model;


import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Restaurant {

	@Column(length = 30)
	private String restaurantName;
	@Id
	@GeneratedValue(generator = "restaurant_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "restaurant_gen",sequenceName = "restaurant_seq",initialValue = 50)
	private Integer restaurantId;
	@Column(length = 20)
	private String category; //veg or nonveg
	@Column(length = 20)
	private String cuisine; // 	southindian,nortindian,italian, continental
	@Column(length = 20)
	private String city;
	// save the child before saving the parent entity
	// fecth the list of items eagerly while getting the restaurant
	@OneToMany(cascade = CascadeType.ALL,fetch=FetchType.EAGER) 
	@JoinColumn(name = "restaurant_id") // to add the restaurant_id in the other table
	private Set<Item> items;
	
	
	
	
	
	
	
	
	
	
	
}
