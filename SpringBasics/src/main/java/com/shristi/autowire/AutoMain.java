package com.shristi.autowire;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi.autowire");
		ShapeFactory factory = context.getBean("shapeFactory",ShapeFactory.class);
		factory.printArea(10, 20);
		
	}
}
