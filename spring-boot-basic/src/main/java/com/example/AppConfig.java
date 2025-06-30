package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.javabased.Department;
import com.example.javabased.Student;
import com.example.javabased1.EmailMessenger;
import com.example.javabased1.MailSender;
import com.example.javabased1.SmsMessenger;
import com.example.javabased1.WhatsAppMessenger;

@Configuration
public class AppConfig {

	// bean definitions
	// methods that return object
	@Bean
	Student getStudent(){
		Student student = new Student();
		// inject department instance using the bean def
		student.setDepartment(department());
		return student;
	}
	@Bean
	Department department() {
		return new Department();
	}
	
	@Bean
	EmailMessenger emailMessenger() {
		return new EmailMessenger();
	}	
	@Bean
	@Primary
	WhatsAppMessenger whatsapp() {
		return new WhatsAppMessenger();
	}
	@Bean
	SmsMessenger smsMessenger() {
		return new SmsMessenger();
	}
	@Bean
	MailSender mailSender() {
		return new MailSender();
	}
	
}




