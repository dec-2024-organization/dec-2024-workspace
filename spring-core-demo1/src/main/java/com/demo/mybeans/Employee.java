package com.demo.mybeans;

public class Employee {
	private int empId;
	private String empName;
	private Department empDeptartment;
	
	public Employee() {}

	public Employee(int empId, String empName, Department empDeptartment) {
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

	public void setEmpDeptartment(Department empDeptartment) {
		this.empDeptartment = empDeptartment;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDeptartment=" + empDeptartment + "]";
	}
}
