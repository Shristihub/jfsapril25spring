package com.shristi.constr;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Student {

	private String studentName;
	private Department department;
	// NO DEFAULT CONSTRUCTOR
	// do not add primitive types in construtor
	// NO NEED OF @Autowired annotation
	//add a paramaterized const only with dependencies
	
	public Student(Department department) {
		super();
		this.department = department;
	}
	
	// no need of setter method for department

	public String getStudentName() {
		return studentName;
	}
	@Value("John")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", department=" + department + "]";
	}

	
	
}
