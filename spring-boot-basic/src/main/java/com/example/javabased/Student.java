package com.example.javabased;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class Student {

	private String studentName;
	private int studentId;
	private Department department;
	public String getStudentName() {
		return studentName;
	}
	@Value("Raju")
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentId() {
		return studentId;
	}
	@Value("10")
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public Department getDepartment() {
		return department;
	}
//	@Autowired(required = false)
	public void setDepartment(Department department) {
		this.department = department;
	}
	@Override
	public String toString() {
		return "Student [studentName=" + studentName + ", studentId=" + studentId + ", department=" + department + "]";
	}
	
	
	
}
