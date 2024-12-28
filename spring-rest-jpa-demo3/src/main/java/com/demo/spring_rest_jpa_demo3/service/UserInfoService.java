package com.demo.spring_rest_jpa_demo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_rest_jpa_demo3.dao.UserInfoRepository;
import com.demo.spring_rest_jpa_demo3.dao.entity.UserInfoEntity;

@Service
public class UserInfoService {
	@Autowired
	UserInfoRepository userInfoRepository;
	
	public List<UserInfoEntity> getAllUsers(){
		return userInfoRepository.findAll();
	}
	
	public Optional<UserInfoEntity> getAUser(String username){
		return userInfoRepository.findById(username);
	}
	
	public UserInfoEntity addUser(UserInfoEntity newUser) {
		return userInfoRepository.saveAndFlush(newUser);
	}
}
