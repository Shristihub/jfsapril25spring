package com.employeeapp.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeeapp.exceptions.EmployeeNotFoundException;
import com.employeeapp.model.Employee;
import com.employeeapp.model.EmployeeDto;
import com.employeeapp.repository.IEmployeeRepository;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

	@Autowired
	private ModelMapper mapper;
	@Autowired
	private IEmployeeRepository employeeRepository;
	
	@Override
	public void addEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);
	}

	@Override
	public void updateEmployee(EmployeeDto employeeDto) {
		Employee employee = mapper.map(employeeDto, Employee.class);
		employeeRepository.save(employee);		
	}

	@Override
	public void deleteEmployee(int employeeId) {
		employeeRepository.deleteById(employeeId);
		
	}

	@Override
	public List<EmployeeDto> getAll() {
		return employeeRepository.findAll()
			.stream()
			.map(empl->mapper.map(empl,EmployeeDto.class))
			.toList();
	}

	@Override
	public EmployeeDto getById(int employeeId) {
		Employee employee =  employeeRepository.findById(employeeId)
			.orElseThrow(()-> new EmployeeNotFoundException("invalid Id"));
		return mapper.map(employee, EmployeeDto.class);
	}

}
