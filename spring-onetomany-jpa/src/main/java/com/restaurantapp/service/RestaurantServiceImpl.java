package com.restaurantapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.restaurantapp.model.Restaurant;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.repository.IRestaurantRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RestaurantServiceImpl implements IRestaurantService{
	
	private final IRestaurantRepository restRepository;
	private final ModelMapper mapper;
	

	@Override
	public void addRestaurant(RestaurantDto restaurantDto) {
		//convert dto into entity
		Restaurant restaurant =  mapper.map(restaurantDto, Restaurant.class);
		restRepository.save(restaurant);
	}

	@Override
	public void updateRestaurant(RestaurantDto restaurantDto) {
		//convert dto into entity
		Restaurant restaurant =  mapper.map(restaurantDto, Restaurant.class);
		restRepository.save(restaurant);
		
	}

	@Override
	public void deleteRestaurant(int restaurantId) {
		restRepository.deleteById(restaurantId);
		
	}

	@Override
	public List<RestaurantDto> getAll() {
		List<Restaurant> restaurants = restRepository.findAll();
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}

	@Override
	public RestaurantDto getById(int restaurantId) {
		Restaurant restaurant =  restRepository.findById(restaurantId)
		 .orElseThrow(()-> new RuntimeException("Invalid Id"));
		return mapper.map(restaurant,RestaurantDto.class);
	}

	@Override
	public List<RestaurantDto> getByCuisine(String cuisine) {
		List<Restaurant> restaurants = restRepository.findByCuisine(cuisine);
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}

	@Override
	public List<RestaurantDto> getByCategory(String category) {
		List<Restaurant> restaurants = restRepository.findByCategory(category);
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}

	@Override
	public List<RestaurantDto> getByCuisineItemType(String cuisine, String itemType) {
		List<Restaurant> restaurants = restRepository.findByCuisineItemType(cuisine, itemType);
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}

	@Override
	public List<RestaurantDto> getByCategoryItemName(String category, String itemName) {
		List<Restaurant> restaurants = restRepository.findByCategoryItemName(category, "%"+itemName+"%");
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}

	@Override
	public List<RestaurantDto> getByItemName(String itemName) {
		List<Restaurant> restaurants = restRepository.findByItemName("%"+itemName+"%");
		return restaurants.stream()
				     .map(restaurant->mapper.map(restaurant,RestaurantDto.class))
				     .toList();
	}
	

}
