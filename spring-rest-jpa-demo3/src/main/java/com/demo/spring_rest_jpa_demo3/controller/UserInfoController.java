package com.demo.spring_rest_jpa_demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_jpa_demo3.dao.entity.UserInfoEntity;
import com.demo.spring_rest_jpa_demo3.service.JwtService;
import com.demo.spring_rest_jpa_demo3.service.UserInfoService;

@RestController
@RequestMapping("/api")
public class UserInfoController {
	@Autowired
	UserInfoService userInfoService;
	
	@Autowired
	AuthenticationManager manager;
	
	@Autowired
	PasswordEncoder encoder;
	
	@Autowired
	JwtService jwtService;
	
	//@PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
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
	
	@PostMapping("/users/validate")
	public ResponseEntity<String> validate(@RequestBody UserInfoEntity userInfo){
		System.out.println("userInfo :" + userInfo);
		//userInfo.setPassword(encoder.encode(userInfo.getPassword()));
		// here validate the userInfo of requestbody using spring security
		Authentication auth = manager.authenticate(new UsernamePasswordAuthenticationToken(userInfo.getUsername(), userInfo.getPassword()));
		if(auth.isAuthenticated()) {
			System.out.println("isAuthentication :" + auth.isAuthenticated());
			System.out.println("credentials :" + auth.getCredentials());
			return new ResponseEntity<String>(jwtService.generateToken(userInfo.getUsername()), HttpStatus.OK);
		}else {
			System.out.println("exception!!!");
			throw new UsernameNotFoundException("Invalid Credentials!");
		}
	}
}
