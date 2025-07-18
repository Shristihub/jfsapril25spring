package com.greetapp.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController //-> @Controller+@ResponseBody
public class HelloController {
	
//	http://localhost:8080/hello
	@GetMapping("/hello")
	public String showMessage() {
		//call the methods of service layer
		//return the data directly
		return "Hello User!!";
	}
	
//	http://localhost:8080/greet/username/Priya
	@GetMapping("/greet/username/{username}")
	public String greetUser(@PathVariable String username) {
		//call the methods of service layer
		//return the data directly
		return "Welcome "+ username;
	}
	
//	http://localhost:8080/search?hotel=Sangeetha
	@GetMapping("/search")
	public List<String> showMenu(@RequestParam("hotel") String hotelname){
		return Arrays.asList("Idli","Dosa","Noodles");
	}
	
	
	
	
}
