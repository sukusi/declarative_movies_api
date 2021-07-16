package com.movies.api.declarative_movies_api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movies.api.declarative_movies_api.model.Movie;
import com.movies.api.declarative_movies_api.service.MovieService;

@RestController
@RequestMapping("movies")
public class MoviesController {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MoviesController.class);

	private MovieService movieService;
	
	@Autowired
	public MoviesController(MovieService movieService) {
		this.movieService = movieService;
	}
	
	@GetMapping(value="/id/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Movie getMovieById(@PathVariable("id") String id) {
		return movieService.getMovieById(id).orElseThrow();
		
	}
	
	@GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getMovies() {
		LOGGER.info("MoviesController::getMovies");
		return movieService.getMovies();
	}
	
	@GetMapping(value="/name/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> getMoviesByName(@PathVariable("name") String name) {
		LOGGER.info("MoviesController::getMoviesByName");
		return movieService.getMoviesByName(name);
	}

}
