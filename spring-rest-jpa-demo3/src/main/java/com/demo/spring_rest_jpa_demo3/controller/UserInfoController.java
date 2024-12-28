package com.demo.spring_rest_jpa_demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_jpa_demo3.dao.entity.UserInfoEntity;
import com.demo.spring_rest_jpa_demo3.service.UserInfoService;

@RestController
@RequestMapping("/api")
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@GetMapping("/users")
	public ResponseEntity<List<UserInfoEntity>> getAllUsers(){
		return new ResponseEntity<List<UserInfoEntity>>(userInfoService.getAllUsers(), HttpStatus.OK);
	}
	
	@GetMapping("/users/{uname}")
	public ResponseEntity<UserInfoEntity> getAUser(@PathVariable("uname") String username){
		return new ResponseEntity(userInfoService.getAUser(username), HttpStatus.OK);
	}
	
	@PostMapping("/users")
	public ResponseEntity<UserInfoEntity> addUser(@RequestBody UserInfoEntity newUser) {
		return new ResponseEntity(userInfoService.addUser(newUser), HttpStatus.OK);
	}
}
