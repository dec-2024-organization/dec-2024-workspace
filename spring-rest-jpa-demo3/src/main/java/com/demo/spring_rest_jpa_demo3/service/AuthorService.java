package com.demo.spring_rest_jpa_demo3.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_rest_jpa_demo3.dao.AuthorRepository;
import com.demo.spring_rest_jpa_demo3.dao.entity.AuthorEntity;
import com.demo.spring_rest_jpa_demo3.pojo.AuthorPojo;
import com.demo.spring_rest_jpa_demo3.pojo.BookPojo;

@Service
public class AuthorService {
	
	@Autowired
	AuthorRepository authorRepo;
	
	public List<AuthorEntity> getAllAuthors(){
		return authorRepo.findAll();
	}

	public List<AuthorPojo> fetchAllAuthors() {
		List<AuthorEntity> allAuthorsEntity = authorRepo.findAll();
		List<AuthorPojo> allAuthorsPojo = new ArrayList<>();
		allAuthorsEntity.forEach((eachAuthorEntity)->{
			AuthorPojo authorPojo = new AuthorPojo();
			BeanUtils.copyProperties(eachAuthorEntity, authorPojo);
			
			List<BookPojo> allBookPojos = new ArrayList<>();
			eachAuthorEntity.getAllBooks().forEach((eachBookEntity)->{
				BookPojo bookPojo = new BookPojo();
				BeanUtils.copyProperties(eachBookEntity, bookPojo);
				allBookPojos.add(bookPojo);
			});
			authorPojo.setAllBooks(allBookPojos);
			allAuthorsPojo.add(authorPojo);
		});
		return allAuthorsPojo;
	}
}
