package com.demo.mybeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	//@Value("6001")
	private int empId;
	
	//@Value("Janet Jackson")
	private String empName;
	
	//@Autowired // field injection
	private Department empDeptartment;
	
	public Employee() {}

	@Autowired
	public Employee(@Value("5001") int empId, @Value("Nick Jonas") String empName, Department empDeptartment) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDeptartment = empDeptartment;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public Department getEmpDeptartment() {
		return empDeptartment;
	}

	//@Autowired // setter injection
	public void setEmpDeptartment(Department empDeptartment) {
		this.empDeptartment = empDeptartment;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDeptartment=" + empDeptartment + "]";
	}
}
