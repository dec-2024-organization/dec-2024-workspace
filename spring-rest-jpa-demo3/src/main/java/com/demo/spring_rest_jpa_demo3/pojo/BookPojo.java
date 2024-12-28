package com.demo.spring_rest_jpa_demo3.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BookPojo {
	private int bookId;
	private String bookTitle;
	private String bookGenre;
	private String bookImgaeUrl;
	private AuthorPojo author;
}
