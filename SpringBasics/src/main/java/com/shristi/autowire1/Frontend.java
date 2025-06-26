package com.shristi.autowire1;

import org.springframework.stereotype.Component;

@Component
public class Frontend implements ICourse{

	@Override
	public void showCourses() {
		System.out.println("AWS & Azure");
	}

}
