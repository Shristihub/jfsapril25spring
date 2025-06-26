package com.shristi.autowire1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoMain {

	public static void main(String[] args) {
		
		ApplicationContext context = 
				new AnnotationConfigApplicationContext("com.shristi.autowire1");
		CourseFactory factory = context.getBean("courseFactory",CourseFactory.class);
		factory.printCourses();;
		
	}
}
