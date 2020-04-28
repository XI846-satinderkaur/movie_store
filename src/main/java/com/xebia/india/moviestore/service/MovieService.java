package com.xebia.india.moviestore.service;

import java.util.List;

import com.xebia.india.moviestore.entity.MovieEntity;
import com.xebia.india.moviestore.exception.RecordNotFoundException;

public interface MovieService {
	
	List<MovieEntity> getMovieList();
	MovieEntity getMovieById(Long movieId) throws RecordNotFoundException;
	MovieEntity createNewMovie(MovieEntity movie);
	MovieEntity updateMovieById(Long movieId) throws RecordNotFoundException ;
	void deleteMovieById(Long movieId) throws RecordNotFoundException;

}
