package com.employeeapp.service;

import java.util.List;

import com.employeeapp.model.EmployeeDto;


public interface IEmployeeService {
	void addEmployee(EmployeeDto employeeDto);
	void updateEmployee(EmployeeDto employeeDto);
	void deleteEmployee(int employeeId);
	List<EmployeeDto> getAll();
	EmployeeDto getById(int employeeId);

}
