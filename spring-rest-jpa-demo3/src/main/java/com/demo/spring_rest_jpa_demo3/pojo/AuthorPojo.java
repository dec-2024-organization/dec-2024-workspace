package com.demo.spring_rest_jpa_demo3.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuthorPojo{
	private int authorId;
	private String authorFirstname;
	private String authorLastname;
	private List<BookPojo> allBooks;
}
