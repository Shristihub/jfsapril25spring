package com.courseapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.courseapp.service.ICourseService;

@SpringBootApplication
public class SpringCourseappBasicApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringCourseappBasicApplication.class, args);
	}

	@Autowired
	private ICourseService courseService;
	
	@Override
	public void run(String... args) throws Exception {
		courseService.getAll().forEach(System.out::println);
	}

}
