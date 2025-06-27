package com.courseapp.service;

import java.util.List;

import com.courseapp.model.Course;

public interface ICourseService {

	  List<Course> getAll();
	  Course getById(int courseId);
	  List<Course> getByType(String type);
	  List<Course> getByLessDurationAndCost(int duration, double cost);
	  List<String> getCourseNames();
	  
}
