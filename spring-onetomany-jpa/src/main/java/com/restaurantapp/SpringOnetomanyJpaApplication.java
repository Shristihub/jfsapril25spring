package com.restaurantapp;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.restaurantapp.model.CATEGORY;
import com.restaurantapp.model.CUISINE;
import com.restaurantapp.model.ITEMTYPE;
import com.restaurantapp.model.Item;
import com.restaurantapp.model.ItemDto;
import com.restaurantapp.model.RestaurantDto;
import com.restaurantapp.service.IRestaurantService;

@SpringBootApplication
public class SpringOnetomanyJpaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetomanyJpaApplication.class, args);
	}
	
	@Autowired
	private IRestaurantService restaurantService;

	
	@Override
	public void run(String... args) throws Exception {
		
		ItemDto item1 = new ItemDto("Masala Dosa", null, ITEMTYPE.BREAKFAST.name(), 160);
		ItemDto item2 = new ItemDto("vanilla Icecream", null, ITEMTYPE.DESSERT.name(), 90);
		ItemDto item3 = new ItemDto("Hot and Sour Soup", null, ITEMTYPE.SOUPS.name(), 60);
		
		Set<ItemDto> itemDtos = new HashSet<>(Arrays.asList(item1, item2,item3));
		
		RestaurantDto restaurantDto =  
		new RestaurantDto("Udupi", null, CATEGORY.VEG.name(),CUISINE.SI.getCuisineType(), "Bengaluru", itemDtos);
		
		//add restaurant
		restaurantService.addRestaurant(restaurantDto);
		
		item1 = new ItemDto("Ghee Dosa", null, ITEMTYPE.BREAKFAST.name(), 260);
		item2 = new ItemDto("Ragi Dosa", null, ITEMTYPE.BREAKFAST.name(), 160);
		item3 = new ItemDto("Full Meals", null, ITEMTYPE.MAINCOURSE.name(), 90);
		
		itemDtos = new HashSet<>(Arrays.asList(item1, item2,item3));
		
		restaurantDto =  
		new RestaurantDto("Sangeetha", null, CATEGORY.VEG.name(),CUISINE.SI.getCuisineType(), "Bengaluru", itemDtos);
		
		restaurantService.addRestaurant(restaurantDto);
		restaurantService.getAll().forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Cuisine");
		restaurantService.getByCuisine(CUISINE.SI.getCuisineType()).forEach(System.out::println);
		
		
		System.out.println();
		System.out.println("Get By Category");
		restaurantService.getByCategory(CATEGORY.NONVEG.name()).forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By Category and itemname");
		restaurantService.getByCategoryItemName(CATEGORY.VEG.name(),"Dosa").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By itemname");
		restaurantService.getByItemName("Soup").forEach(System.out::println);
		
		System.out.println();
		System.out.println("Get By itemtype and cuisine");
		restaurantService.getByCuisineItemType(CUISINE.SI.getCuisineType(),"BREAKFAST").forEach(System.out::println);
		
		
	}

}
