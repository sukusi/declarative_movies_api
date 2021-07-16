package com.movies.api.declarative_movies_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.movies.api.declarative_movies_api.model.Movie;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

	@Query("{'name':?0}")
	List<Movie> findByName(String name);



}
