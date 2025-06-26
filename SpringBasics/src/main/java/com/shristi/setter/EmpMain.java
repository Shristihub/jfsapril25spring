package com.shristi.setter;

import java.util.Arrays;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class EmpMain {

	public static void main(String[] args) {
		//create the IoCContainer - 
		// all springbeans are created by the IoC Container
		ApplicationContext context = new AnnotationConfigApplicationContext("com.shristi");
		Arrays.stream(context.getBeanDefinitionNames())
		  .forEach(bean->System.out.println(bean));
		
		System.out.println();
		// getting the bean from the IoC Container
		Employee employee = (Employee) context.getBean("employee");
		System.out.println(employee);
	}

}
