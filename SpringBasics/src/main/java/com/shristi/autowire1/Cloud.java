package com.shristi.autowire1;

import org.springframework.stereotype.Component;

@Component
public class Cloud implements ICourse{

	@Override
	public void showCourses() {
		System.out.println("Spring & microservices");
	}

}
