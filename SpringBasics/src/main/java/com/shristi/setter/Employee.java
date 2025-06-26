package com.shristi.setter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class Employee {
	private String employeeName;
	private double salary;
	private Address address; 
	
	
	public String getEmployeeName() {
		return employeeName;
	}
	@Value("${employee.employeeName}")
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public double getSalary() {
		return salary;
	}
	@Value("${employee.salary}")
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	//add setter/getter method
	public Address getAddress() {
		return address;
	}
	//add @Autowired annotation to inject address object into employee object
	@Autowired
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Employee [employeeName=" + employeeName + ", salary=" + salary + ", address=" + address + "]";
	}
	
}
