package com.demo.spring_rest_jpa_demo3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.spring_rest_jpa_demo3.dao.BookRepository;
import com.demo.spring_rest_jpa_demo3.dao.entity.BookEntity;
import com.demo.spring_rest_jpa_demo3.pojo.AuthorPojo;
import com.demo.spring_rest_jpa_demo3.pojo.BookPojo;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepo;
	
	public List<BookEntity> getAllBooks(){
		return bookRepo.findAll();
	}
	
	public BookEntity getABook(int bookId) {
		BookEntity fetchedBook = null;
		Optional<BookEntity> optionalBookEntity = bookRepo.findById(bookId);
		if(optionalBookEntity.isPresent()) {
			fetchedBook = optionalBookEntity.get();
		}
		return fetchedBook;
	}
	
	public BookEntity addBook(BookEntity newBook) {
		return bookRepo.saveAndFlush(newBook);
	}
	
	public BookEntity updateBook(BookEntity editBook) {
		return bookRepo.save(editBook);
	}
	
	public void deleteBook(int bookId) {
		bookRepo.deleteById(bookId);
	}
	
	public List<BookPojo> fetchAllBooks(){
		List<BookEntity> allBooksEntity = bookRepo.findAll();
		List<BookPojo> allBooksPojo = new ArrayList<>();
		allBooksEntity.stream().forEach((eachBookEntity)->{
			BookPojo bookPojo = new BookPojo();
			BeanUtils.copyProperties(eachBookEntity, bookPojo);
			AuthorPojo authorPojo = new AuthorPojo();
			BeanUtils.copyProperties(eachBookEntity.getAuthor(), authorPojo);
			bookPojo.setAuthor(authorPojo);
			allBooksPojo.add(bookPojo);
		});
		return allBooksPojo;
	}
}
