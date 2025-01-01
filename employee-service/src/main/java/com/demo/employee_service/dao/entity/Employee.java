package com.demo.employee_service.dao.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="employee-details")
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;
	
	@Column(name="emp_name")
	private String empName;
	
	@Column(name="emp_designation")
	private String empDesignation;
	
	@Column(name="emp_dept_id")
	private int empDeptId;
}
