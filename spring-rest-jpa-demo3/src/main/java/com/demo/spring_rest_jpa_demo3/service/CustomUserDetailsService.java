package com.demo.spring_rest_jpa_demo3.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.demo.spring_rest_jpa_demo3.dao.UserInfoRepository;
import com.demo.spring_rest_jpa_demo3.dao.entity.UserInfoEntity;

public class CustomUserDetailsService implements UserDetailsService{

	@Autowired 
	UserInfoRepository userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<UserInfoEntity> userEntityOptional = userRepo.findByUsername(username);
		// we have to return the username, password and collection 
			//of roles in a UserDetails implementtion object
		// but we have got all this info in a UserInfoEntity
		// so we have to copy username, password and collection of role into 
			//an object of UserDetails implementation having username , password 
			//and collection of SimpleGrantedAuthority
		//so for this we will create CustomUserDetails class which implements UserDetails
		
//		if(userEntityOptional.isPresent()) {
//			CustomUserDetails userDetails = new CustomUserDetails(userEntityOptional.get());
//			return userDetails;
//		} else {
//			throw new UsernameNotFoundException(username + " not found");
//		}
		
		System.out.println("load : " + userEntityOptional.get());
		return userEntityOptional
				.map((userEntity) -> new CustomUserDetails(userEntity))
				.orElseThrow(() -> new UsernameNotFoundException(username + " not found"));
	}
}
