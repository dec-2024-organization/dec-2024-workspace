package com.demo.spring_rest_jpa_demo3.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.NativeQuery;
import org.springframework.stereotype.Repository;

import com.demo.spring_rest_jpa_demo3.dao.entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Integer> {

	//4 ways
	//1. finder/query methods
	//2. @Query with JPQL
	//3. @NativeQuery with native sql
	//4. CriteriaQuery
	
	// 1.
//	List<BookEntity> findByBookGenre(String bGenre);
	
	//2. 
//	@Query("select b from BookEntity b where b.bookGenre=:bGenre")
//	List<BookEntity> getBooksByGenre(@Param("bGenre") String bookGenre);
	
	//3.
	@NativeQuery(value = "select * from book_details where book_genre=?1")
	List<BookEntity> getBooksByGenre(String bookGenre);
}
