package com.demo.spring_rest_jpa_demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_jpa_demo3.dao.entity.AuthorEntity;
import com.demo.spring_rest_jpa_demo3.pojo.AuthorPojo;
import com.demo.spring_rest_jpa_demo3.service.AuthorService;

@RestController
@RequestMapping("/api")
public class AuthorController {

	@Autowired
	AuthorService authorService;
	
	@GetMapping("/authors")
	public ResponseEntity<List<AuthorEntity>> getAllAuthors(){
		return new ResponseEntity<List<AuthorEntity>>(authorService.getAllAuthors(), HttpStatus.OK);
	}
	
	@GetMapping("/v2/authors")
	public ResponseEntity<List<AuthorPojo>> fetchAllAuthors(){
		return new ResponseEntity<List<AuthorPojo>>(authorService.fetchAllAuthors(), HttpStatus.OK);
	}
}
