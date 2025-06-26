package com.shristi.constr;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StudMain {

	public static void main(String[] args) {
		//create the IoCContainer - 
		// all springbeans are created by the IoC Container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.shristi");
		Arrays.stream(context.getBeanDefinitionNames())
		  .forEach(bean->System.out.println(bean));
		
		System.out.println();
		// getting the bean from the IoC Container
		Student student1 = (Student) context.getBean("student");
		System.out.println(student1);
		System.out.println();
		
		System.out.println("Student1 "+student1.getStudentName());
		
		
		//create  a new reference
		Student student2 = (Student)context.getBean("student");
		System.out.println("Student2 "+student2.getStudentName());
		
		student2.setStudentName("Rohit");
		System.out.println("Student1 "+student1.getStudentName());
		System.out.println("Student2 "+student2.getStudentName());
	}

	
	
	
	
}
