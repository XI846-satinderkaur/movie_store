package com.tech.india.moviestore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.india.moviestore.entity.MovieEntity;
import com.tech.india.moviestore.exception.RecordNotFoundException;
import com.tech.india.moviestore.repository.MovieStoreRepository;

@Service
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieStoreRepository repository;

	public List<MovieEntity> getMovieList() {
		List<MovieEntity> movieList = repository.findAll();
		 if(movieList.size() > 0) {
	            return movieList;
	        } else {
	            return new ArrayList<MovieEntity>();
	        }
	}

	public MovieEntity getMovieById(Long movieId) throws RecordNotFoundException{
		Optional<MovieEntity> movie = repository.findById(movieId);
		if(movie.isPresent()) {
            return movie.get();
        } else {
            throw new RecordNotFoundException("No movie record exist for given movie-id");
        }
		//return dao.getMovieById(movieId);
	}

	public MovieEntity createNewMovie(MovieEntity movie){
		return repository.save(movie);
		
	}

	public MovieEntity updateMovieById(Long movieId) throws RecordNotFoundException{
		Optional<MovieEntity> movie = repository.findById(movieId);
		MovieEntity newEntity = new MovieEntity();
		if(movie.isPresent()){			
			newEntity.setTitle(movie.get().getTitle());
			newEntity.setCategory(movie.get().getCategory());
			newEntity.setRatings(movie.get().getRatings());	
			newEntity = repository.save(newEntity);			 
		}
		else{
			throw new RecordNotFoundException("No movie record exist for given id");
		}
		return newEntity;
	}

	public void deleteMovieById(Long movieId) throws RecordNotFoundException{
		Optional<MovieEntity> movie = repository.findById(movieId);
		if(movie.isPresent()){
			repository.deleteById(movieId);
		}
		else {
            throw new RecordNotFoundException("No movie record exist for given id");
        }
	}
}
