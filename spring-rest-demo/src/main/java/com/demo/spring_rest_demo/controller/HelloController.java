package com.demo.spring_rest_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

	// create your rest methods/endpoints here
	
	//http://localhost:1212/api/hello
	@GetMapping("/hello")
	public String sayHello() {
		return "Good Afternoon!!";
	}
}
