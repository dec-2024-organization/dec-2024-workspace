package com.demo.spring_rest_jpa_demo3.dao.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="userinfo")
public class UserInfoEntity {
	@Id
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@ManyToMany
	@JoinTable(name="userinfo_role_details",
				joinColumns = @JoinColumn(name="username"),
				inverseJoinColumns = @JoinColumn(name="role_id"))
	List<RoleEntity> allRoles;
}
