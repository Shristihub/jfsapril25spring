package com.studentapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapp.model.Student;
import com.studentapp.model.StudentDto;
import com.studentapp.repository.IStudentRepository;

@Service
public class StudentServiceImpl implements IStudentService{
	
	@Autowired
	private IStudentRepository studentRepository;
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public void addStudent(StudentDto studentDto) {
		// convert dto object to entity
		Student student = mapper.map(studentDto, Student.class);
		studentRepository.save(student);
		
	}

	@Override
	public void updateStudent(StudentDto studentDto) {
		Student student = mapper.map(studentDto, Student.class);
		studentRepository.save(student);		
	}

	@Override
	public void deleteStudent(int studentId) {
		studentRepository.deleteById(studentId);
		
	}

	@Override
	public List<StudentDto> getAll() {
		List<Student> students =  studentRepository.findAll();
		return students.stream()
				.map(student->mapper.map(student, StudentDto.class))
				.toList();
		
	}

	@Override
	public StudentDto getById(int studentId) {
		Student student =  studentRepository.findById(studentId)
				.orElseThrow(()-> new RuntimeException("Invalid Id"));
		return mapper.map(student, StudentDto.class);
	}

	@Override
	public List<StudentDto> getByDepartment(String department) {
		return null;
	}

	@Override
	public List<StudentDto> getByCity(String city) {
		List<Student> students =  studentRepository.findByAddressCity(city);
		List<StudentDto> stdtos =  students.stream()
				.map(student->mapper.map(student, StudentDto.class))
				.toList();
		System.out.println(stdtos);
		return stdtos;
	}

	@Override
	public List<StudentDto> getByState(String state) {
		List<Student> students =  studentRepository.findByState(state);
		return students.stream()
				.map(student->mapper.map(student, StudentDto.class))
				.toList();
	}

}
