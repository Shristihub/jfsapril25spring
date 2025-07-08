package com.restaurantapp.model;


import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RestaurantDto {

	private String restaurantName;
	private Integer restaurantId;
	private String category; //veg or nonveg
	private String cuisine; // 	southindian,nortindian,italian, continental
	private String city;
	
	private Set<ItemDto> items;
	
	
	
	
	
	
	
	
	
	
	
}
