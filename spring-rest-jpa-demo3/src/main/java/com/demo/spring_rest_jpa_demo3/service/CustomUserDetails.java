package com.demo.spring_rest_jpa_demo3.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.demo.spring_rest_jpa_demo3.dao.entity.UserInfoEntity;

public class CustomUserDetails implements UserDetails{

	private String username;
	private String password;
	private List<SimpleGrantedAuthority> allRoles;
	
	public CustomUserDetails(UserInfoEntity userEntity) {
		this.username = userEntity.getUsername();
		this.password = userEntity.getPassword();
		this.allRoles = userEntity
							.getAllRoles()
							.stream()
							.map((eachRole)->new SimpleGrantedAuthority(eachRole.getRoleName()))
							.toList();
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.allRoles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}
}
