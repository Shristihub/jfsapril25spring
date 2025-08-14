package com.greetapp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetController {

	@GetMapping("/greet/{username}")
	public String greetUser(@PathVariable String username) {
		return "Have a great day "+username;
	}
}
