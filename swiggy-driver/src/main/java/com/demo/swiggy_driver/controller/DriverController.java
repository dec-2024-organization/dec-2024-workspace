package com.demo.swiggy_driver.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.swiggy_driver.service.DriverService;

@RestController
@RequestMapping("/api")
public class DriverController {
	
	@Autowired
	DriverService driverService;
	
	@PutMapping("/drivers/location")
	public ResponseEntity<Map<String, String>> driverLocation() {
		driverService.driverLocation();
		Map<String, String> data = new HashMap<String, String>();
		data.put("Message", "Driver Location Updated!");
		return new ResponseEntity<Map<String, String>>(data, HttpStatus.OK);
	}

}
