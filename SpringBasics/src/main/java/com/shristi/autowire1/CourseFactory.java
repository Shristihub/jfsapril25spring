package com.shristi.autowire1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CourseFactory {

	@Autowired
	@Qualifier("backend")
	private ICourse course;
	
	public void printCourses() {
		course.showCourses();
	}
}
