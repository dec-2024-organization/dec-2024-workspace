package com.demo.movie_service.pojo;

import java.time.LocalDate;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class MoviePojo {
	private int movieId;
	@NotNull
	private String movieTitle;
	
	@NotNull
	private String movieLanguage;
	
	@NotNull
	private LocalDate movieReleaseDate;
	private String movieImageUrl;
}