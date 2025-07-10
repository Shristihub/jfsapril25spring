package com.employeeapp.model;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmployeeDto {
	private String employeeName;
	private Integer employeeId;
	private AddressDto address;
	private Set<InsuranceDto> insurances;
	private DepartmentDto department;
	private Set<CourseDto> courses;
	private Set<String> hobbies; //["sports"],["sports","music"]
	

}


