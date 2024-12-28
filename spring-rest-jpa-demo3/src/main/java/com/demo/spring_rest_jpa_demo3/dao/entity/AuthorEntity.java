package com.demo.spring_rest_jpa_demo3.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "authorId")

@Entity
@Table(name = "author_details")
public class AuthorEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "author_id")
	private int authorId;

	@Column(name = "author_firstname")
	private String authorFirstname;

	@Column(name = "author_lastname")
	private String authorLastname;

	@OneToMany(mappedBy="author")
	@JsonBackReference
	private List<BookEntity> allBooks;
	
}
