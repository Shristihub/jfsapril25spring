package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exceptions.DepartmentNotFoundException;
import com.employeeapp.model.Department;
import com.employeeapp.model.DepartmentDto;
import com.employeeapp.repository.IDepartmentRepository;

@Service
public class DepartmentServiceImpl implements IDepartmentService{

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IDepartmentRepository departmentRepository;
	
	@Override
	public void addDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
	}

	@Override
	public void updateDepartment(DepartmentDto departmentDto) {
		Department department = mapper.map(departmentDto, Department.class);
		departmentRepository.save(department);
	}

	@Override
	public void deleteDepartment(int departmentId) {
		departmentRepository.deleteById(departmentId);
		
	}

	@Override
	public List<DepartmentDto> getAll() {
		return departmentRepository.findAll()
				.stream()
				.map(department->mapper.map(department,DepartmentDto.class))
				.toList();
			
	}

	@Override
	public DepartmentDto getById(int departmentId) {
		Department department = departmentRepository.findById(departmentId)
				.orElseThrow(()-> new DepartmentNotFoundException("invalid department id"));
			
		return mapper.map(department, DepartmentDto.class);
	
	
	}

}
