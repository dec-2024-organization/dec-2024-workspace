package com.demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.demo.config.BeanConfig;
import com.demo.mybeans.Employee;
import com.demo.mybeans.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person(204, "Harry", "Potter");
		System.out.println(person1);
		
		ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
		Person person2 = context.getBean("person", Person.class);
		System.out.println(person2);
		
		Employee emp1 = context.getBean("employee", Employee.class);
		System.out.println(emp1);
	}

}
