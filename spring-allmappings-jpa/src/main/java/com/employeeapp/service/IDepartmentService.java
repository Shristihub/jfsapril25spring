package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.DepartmentDto;

public interface IDepartmentService {
	void addDepartment(DepartmentDto departmentDto);
	void updateDepartment(DepartmentDto departmentDto);
	void deleteDepartment(int departmentId);
	List<DepartmentDto> getAll();
	DepartmentDto getById(int departmentId);

}
