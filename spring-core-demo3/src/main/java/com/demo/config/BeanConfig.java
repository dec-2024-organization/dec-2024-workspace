package com.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.demo.mybeans.Department;
import com.demo.mybeans.Employee;
import com.demo.mybeans.Person;

@Configuration
public class BeanConfig {

	// here configure the spring beans
	@Bean
	public Person person() {
//		return new Person(201, "Albus", "Dumbledore");
		Person per = new Person();
		per.setPersonId(201);
		per.setPersonFirstName("Albus");
		per.setPersonLastName("Dumbledore");
		return per;
	}
	
	@Bean
	public Department department() {
		return new Department(105, "IT");
	}
	
	@Bean
	public Employee employee() {
		Employee emp = new Employee(6060, "Ron Weasely", department());
//		emp.setEmpId(6060);
//		emp.setEmpName("Ron Weasely");
//		emp.setEmpDeptartment(department()); // setter injection
		return emp;
	}
	
}
