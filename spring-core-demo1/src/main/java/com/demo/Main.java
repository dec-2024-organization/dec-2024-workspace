package com.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.demo.mybeans.Employee;
import com.demo.mybeans.Person;

public class Main {

	public static void main(String[] args) {
		Person person1 = new Person(101, "Will", "Smith");
		System.out.println(person1);

		// first create the IOC container
		ClassPathXmlApplicationContext context  = new ClassPathXmlApplicationContext("any-name.xml");
		
		// as the IOC container for an object of Person
		Person person2 = context.getBean("per", Person.class);
		System.out.println(person2);
		
		Person person3 = context.getBean("per1", Person.class);
		System.out.println(person3);
		
		Employee employee1 = context.getBean("emp1", Employee.class);
		System.out.println(employee1);
		
	}

}
