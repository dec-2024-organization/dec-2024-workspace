package com.demo.spring_rest_demo2.controller;

import java.util.List;

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

import com.demo.spring_rest_demo2.pojo.PropertyPojo;
import com.demo.spring_rest_demo2.service.PropertyService;

@RestController
@RequestMapping("/api")
public class PropertyController{

	@Autowired 
	PropertyService propertyService;

	@GetMapping("/properties")
	public ResponseEntity<List<PropertyPojo>> getAllProperties() {
		return new ResponseEntity(propertyService.getAllProperties(), HttpStatus.OK);
	}

	@GetMapping("/properties/{pid}")
	public ResponseEntity<PropertyPojo> getAProperty(@PathVariable("pid") int propertyId) {
		return new ResponseEntity(propertyService.getAProperty(propertyId), HttpStatus.OK);
	}

	@PostMapping("/properties")
	public ResponseEntity<PropertyPojo> addProperty(@RequestBody PropertyPojo newProperty) {
		return new ResponseEntity(propertyService.addProperty(newProperty), HttpStatus.OK);
	}

	@PutMapping("/properties")
	public ResponseEntity<PropertyPojo> updateProperty(@RequestBody PropertyPojo editProperty) {
		return new ResponseEntity(propertyService.updateProperty(editProperty), HttpStatus.OK);
	}

	@DeleteMapping("/properties/{pid}")
	public ResponseEntity<Void> deleteProperty(@PathVariable("pid") int propertyId) {
		propertyService.deleteProperty(propertyId);
		return new ResponseEntity(HttpStatus.OK);
	}
}
