package com.demo.spring_rest_jpa_demo3.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_rest_jpa_demo3.dao.entity.BookEntity;
import com.demo.spring_rest_jpa_demo3.pojo.BookPojo;
import com.demo.spring_rest_jpa_demo3.service.BookService;

@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/books")
	public ResponseEntity<List<BookEntity>> getAllBooks(){
		return new ResponseEntity<List<BookEntity>>(bookService.getAllBooks(), HttpStatus.OK);
	}
	
	@GetMapping("/books/{bid}")
	public ResponseEntity<BookEntity> getABook(@PathVariable("bid") int bookId) {
		return new ResponseEntity(bookService.getABook(bookId), HttpStatus.OK);
	}
	
	@PostMapping("/books")
	public ResponseEntity<BookEntity> addBook(@RequestBody BookEntity newBook) {
		return new ResponseEntity(bookService.addBook(newBook), HttpStatus.OK);
	}
	
	@PutMapping("/books")
	public ResponseEntity<BookEntity> updateBook(@RequestBody BookEntity editBook) {
		return new ResponseEntity(bookService.updateBook(editBook), HttpStatus.OK);
	}
	
	@DeleteMapping("/books/{bid}")
	public ResponseEntity<Void> deleteBook(@PathVariable("bid") int bookId) {
		bookService.deleteBook(bookId);
		return new ResponseEntity(HttpStatus.OK);
	}
	
	@GetMapping("/v2/books")
	public ResponseEntity<List<BookPojo>> fetchAllBooks(){
		return new ResponseEntity(bookService.fetchAllBooks(), HttpStatus.OK);
	}
}
