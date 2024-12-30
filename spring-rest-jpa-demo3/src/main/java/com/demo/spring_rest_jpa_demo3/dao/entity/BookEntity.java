package com.demo.spring_rest_jpa_demo3.dao.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "bookId")

@Entity
@Table(name="book_details")
public class BookEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="book_id")
	private int bookId;
	
	@Column(name="book_title")
	private String bookTitle;
	
	@Column(name="book_genre")
	private String bookGenre;
	
	@Column(name="book_image_url")
	private String bookImgaeUrl;
	
//	@Column(name="book_author_id")
//	private int bookAuthorId;
	
	@ManyToOne
	@JoinColumn(name="book_author_id")
	@JsonManagedReference
	private AuthorEntity author;
	
	@ManyToMany
	@JoinTable(name="book_character_details", 
				joinColumns = @JoinColumn(name="book_id"),
				inverseJoinColumns = @JoinColumn(name="char_id"))
	private List<CharacterEntity> allCharacters;
	
	@ManyToOne
	@JoinColumn(name="publisher_username")
	private UserInfoEntity userInfo;
	
}
