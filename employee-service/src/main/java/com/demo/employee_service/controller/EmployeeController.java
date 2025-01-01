package com.demo.employee_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.employee_service.dao.entity.Employee;
import com.demo.employee_service.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	EmployeeService empService;
	
	@GetMapping("/employees/dept/{did}")
	public ResponseEntity<List<Employee>> getEmployeesByDepartment(@PathVariable("did") int deptId){
		return new ResponseEntity<List<Employee>>(empService.getEmployeesByDepartment(deptId), HttpStatus.OK);	
	}
	
	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> getAllEmployees(){
		return new ResponseEntity<List<Employee>>(empService.getAllEmployees(), HttpStatus.OK);
	}
	
	@GetMapping("/employees/{eid}")
	public ResponseEntity<Optional<Employee>> getAEmployee(@PathVariable("eid") int empId){
		return new ResponseEntity<Optional<Employee>>(empService.getAEmployee(empId), HttpStatus.OK);	
	}
	
	@PostMapping("/employees")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee newEmp) {
		return new ResponseEntity<Employee>(empService.addEmployee(newEmp),HttpStatus.OK);
	}
	
	@PutMapping("/employees")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee editEmp) {
		return new ResponseEntity<Employee>(empService.updateEmployee(editEmp),HttpStatus.OK);
	}
	
	@DeleteMapping("/employees/{did}")
	public ResponseEntity<Void> deleteEmployee(@PathVariable("did") int empId) {
		empService.deleteEmployee(empId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
}
