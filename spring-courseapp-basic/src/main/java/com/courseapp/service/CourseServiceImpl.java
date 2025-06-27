package com.courseapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.courseapp.exception.CourseNotFoundException;
import com.courseapp.model.Course;
import com.courseapp.util.CourseUtil;

@Service
public class CourseServiceImpl implements ICourseService{
	
	// instance of CourseUtil
	private CourseUtil courseUtil;
	
	@Autowired
	public void setCourseUtil(CourseUtil courseUtil) {
		this.courseUtil = courseUtil;
	}

	@Override
	public List<Course> getAll() {
		return courseUtil.getAllCourses();
	}

	@Override
	public Course getById(int courseId) {
		List<Course> courses = courseUtil.getAllCourses();
//		Optional<Course> courseopt = courses.stream()
//					.filter(course->course.getCourseId()==courseId)
//					.findFirst();
//		if(courseopt.isPresent())
//			return courseopt.get();
//		return null;
		
		return courses.stream()
		.filter(course->course.getCourseId()==courseId)
		.findFirst()
		.orElseThrow(()->new CourseNotFoundException("invalid id"));
		
	}

	@Override
	public List<Course> getByType(String type) {
		List<Course> courses = courseUtil.getAllCourses();
		List<Course> ncourses = courses.stream()
				.filter(course->course.getType().equals(type))
				.toList();
		if(ncourses.isEmpty())
			throw new CourseNotFoundException("type not found");
		return ncourses;
				
	}

	@Override
	public List<Course> getByLessDurationAndCost(int duration, double cost) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCourseNames() {
		// TODO Auto-generated method stub
		return null;
	}

}
