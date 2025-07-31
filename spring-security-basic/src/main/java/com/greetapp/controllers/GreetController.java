package com.greetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/greet")
	public String greet() {
		return "Have a great day";
	}
	
	@GetMapping("/show")
	public String show() {
		return "Showing data";
	}
}
