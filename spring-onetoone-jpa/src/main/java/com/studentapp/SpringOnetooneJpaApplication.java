package com.studentapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.studentapp.model.AddressDto;
import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.service.IStudentService;

@SpringBootApplication
public class SpringOnetooneJpaApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringOnetooneJpaApplication.class, args);
	}

	@Autowired
	private IStudentService studentService;
	
	@Override
	public void run(String... args) throws Exception {
		//create student object
		AddressDto addressDto = new AddressDto("Cochin", null, "Kerala");
		//create student object
		StudentDto studentDto = new StudentDto("Rahul",null, "ECE",addressDto);
//		studentService.addStudent(studentDto);
		
		//call update, delete, get by id
		studentService.getAll().forEach(System.out::println);
		System.out.println();
		
		System.out.println("Get By City");
		studentService.getByCity("Bengaluru").forEach(System.out::println);
		System.out.println();
		
		System.out.println("Get By State");
		studentService.getByState("KAR").forEach(student-> System.out.println(student.getAddressDto()));
		System.out.println();
		
	}

}
