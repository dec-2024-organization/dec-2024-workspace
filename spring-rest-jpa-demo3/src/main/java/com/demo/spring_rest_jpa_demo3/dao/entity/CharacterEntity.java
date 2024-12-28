package com.demo.spring_rest_jpa_demo3.dao.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
@Table(name = "character_details")
public class CharacterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "char_id")
	private int charId;

	@Column(name = "char_firstname")
	private String charFirstname;

	@Column(name = "char_lastname")
	private String charLastname;
	
	// for this to work
	//1. copy entity to pojo to avoid cyclic/circular 
			//referencing due to bidirectional mapping
	//2. create CharacterRepository, CharacterService and CharacterController
//	@ManyToMany(mappedBy="allCharacters")
//	private List<BookEntity> allBooks;
	
}
