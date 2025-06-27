package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.autowire.ShapeFactory;
import com.example.javabased.Student;
import com.example.javabased1.MailSender;
import com.shristi.setter.Employee;

@SpringBootApplication(scanBasePackages = {"com.shristi","com.example"})
public class SpringBootBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBasicApplication.class, args);
	}

//	@Autowired
//	ApplicationContext context;
	
	@Autowired
	private Employee employee;
	
	@Autowired
	private Student student;
	
	@Autowired
	private MailSender mailSender;
	
	private ShapeFactory factory;
	@Autowired
	public void setFactory(ShapeFactory factory) {
		this.factory = factory;
	}


	@Override
	public void run(String... args) throws Exception {
//		Employee employee =  context.getBean("employee",Employee.class);
//		System.out.println(employee);
//		
//		Arrays.stream(context.getBeanDefinitionNames())
//		  .forEach(bean->System.out.println(bean));
//		
		System.out.println(employee);
		factory.printArea(20, 30);
		System.out.println(student);
		
		mailSender.showMessage();
	}

}
