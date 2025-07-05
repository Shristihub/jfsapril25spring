package com.studentapp.service;

import java.util.List;

import com.studentapp.model.StudentDto;

public interface IStudentService {

	void addStudent(StudentDto studentDto);
	void updateStudent(StudentDto studentDto);
	void deleteStudent(int studentId);
	List<StudentDto> getAll();
	StudentDto getById(int studentId);
	
	List<StudentDto> getByDepartment(String department);
	List<StudentDto> getByCity(String city);
	List<StudentDto> getByState(String state);
}
