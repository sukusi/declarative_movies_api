package com.movies.api.declarative_movies_api.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movies.api.declarative_movies_api.model.Movie;
import com.movies.api.declarative_movies_api.repository.MovieRepository;

@Service
public class MovieService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(MovieService.class);

	private MovieRepository movieRepository;

	@Autowired
	public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public Optional<Movie> getMovieById(String id) {
		LOGGER.info("MovieService::getMovieById for id {}", id);
		return movieRepository.findById(id);
	}

	public List<Movie> getMovies() {
		LOGGER.info("MovieService::getMovies");
		return movieRepository.findAll();
	}

	public List<Movie> getMoviesByName(String name) {
		LOGGER.info("MovieService::getMoviesByName for name {}", name);
		return movieRepository.findByName(name);
	}

}
