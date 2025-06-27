package com.example.javabased;

import org.springframework.beans.factory.annotation.Value;

public class Department {
	private String deptName;
	private String deptHead;
	public String getDeptName() {
		return deptName;
	}
	@Value("CSE")
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getDeptHead() {
		return deptHead;
	}
	@Value("Menaka")
	public void setDeptHead(String deptHead) {
		this.deptHead = deptHead;
	}
	@Override
	public String toString() {
		return "Department [deptName=" + deptName + ", deptHead=" + deptHead + "]";
	}

}
