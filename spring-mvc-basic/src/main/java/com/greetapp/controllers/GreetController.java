package com.greetapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.greetapp.service.IBookService;

@Controller
public class GreetController {
	
	// autowire service
	private IBookService bookService;
	
	@Autowired
	public void setBookService(IBookService bookService) {
		this.bookService = bookService;
	}

	@RequestMapping("/greet")
	public String greetMessage(ModelMap map) {
		//call the methods of service layer
		// this is the data requested by the client
		String message = "Have a great day";
		//attach the data to the model and give a dummy name
		map.addAttribute("mymessage", message);
		
		return "success"; // view page name
	}
	
	@RequestMapping("/sayHello")
	public String helloMessage(Model model) {
		//call the methods of service layer
		// this is the data requested by the client
		String message = "Hello!!";
		//attach the data to the model and give a dummy name
		model.addAttribute("mymessage", message);
		
		return "success"; // view page name
	}
	
	@RequestMapping("/welcome")
	public ModelAndView helloMessage() {
		//call the methods of service layer
		// this is the data requested by the client
		//create a modelview which has both
		ModelAndView modelView = new ModelAndView("success","message","Welcome to MVC");
		return modelView; 
	}
	
	@RequestMapping("/books")
	public String getBooks(Model model) {
		//call the methods of service layer
		// this is the data requested by the client
		List<String> books = bookService.getBooks();
		//attach the data to the model and give a dummy name
		model.addAttribute("bookList",books);
		return "success"; // view page name
	}
	
}
