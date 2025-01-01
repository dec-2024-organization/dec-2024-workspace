package com.demo.employee_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.employee_service.dao.EmployeeRepository;
import com.demo.employee_service.dao.entity.Employee;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepo;
	
	public List<Employee> getEmployeesByDepartment(int deptId){
		return empRepo.findByEmpDeptId(deptId);
	}
	
	public List<Employee> getAllEmployees(){
		return empRepo.findAll();
	}
	
	public Optional<Employee> getAEmployee(int empId){
		return empRepo.findById(empId);
	}
	
	public Employee addEmployee(Employee newEmp) {
		return empRepo.saveAndFlush(newEmp);
	}
	
	public Employee updateEmployee(Employee editEmp) {
		return empRepo.save(editEmp);
	}
	
	public void deleteEmployee(int empId) {
		empRepo.deleteById(empId);
	}
}