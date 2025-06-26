package com.shristi.autowire1;

import org.springframework.stereotype.Component;

@Component
public class Backend implements ICourse{

	@Override
	public void showCourses() {
		System.out.println("Spring & microservices");
	}

}
