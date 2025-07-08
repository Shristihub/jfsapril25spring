package com.restaurantapp.service;

import java.util.List;

import com.restaurantapp.model.RestaurantDto;


public interface IRestaurantService {

	void addRestaurant(RestaurantDto restaurantDto);
	void updateRestaurant(RestaurantDto restaurantDto);
	void deleteRestaurant(int restaurantId);
	List<RestaurantDto> getAll();
	RestaurantDto getById(int restaurantId);
	
	List<RestaurantDto> getByCuisine(String cuisine);
	List<RestaurantDto> getByCategory(String category);
	List<RestaurantDto> getByCuisineItemType(String cuisine,String itemType);
	List<RestaurantDto> getByCategoryItemName(String category,String itemName);
	List<RestaurantDto> getByItemName(String itemName);
	
	
	
	
	
	
	
}
