package com.restaurantapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ItemDto {
	
	private String itemName;
	private Integer itemId;
	private String itemtype; //breakfast,lunch,dessert,maincourse,soups
	private double price; 
	
}
