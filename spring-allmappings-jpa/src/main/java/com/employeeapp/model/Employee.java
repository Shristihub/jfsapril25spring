package com.employeeapp.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Employee {
	@Column(length=20)
	private String employeeName;
	@Id
	@GeneratedValue(generator = "employee_gen",strategy = GenerationType.AUTO)
	@SequenceGenerator(name = "employee_gen",sequenceName = "employee_seq",initialValue = 1)
	private Integer employeeId;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="address_id") //added to employee table
	private Address address;
	
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="employee_id") //added to insurance table
	private Set<Insurance> insurances;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="dept_id") //added to employee table
	private Department department;
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "empl_courses", 
	           joinColumns = @JoinColumn(name="employee_id"),
	           inverseJoinColumns = @JoinColumn(name="course_id"))
	private Set<Course> courses;
	@ElementCollection
	@CollectionTable(name="hobbies")
	private Set<String> hobbies; //["sports"],["sports","music"]
	

}


