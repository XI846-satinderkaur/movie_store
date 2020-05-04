package com.tech.india.moviestore.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tech.india.moviestore.entity.MovieEntity;
import com.tech.india.moviestore.exception.RecordNotFoundException;
import com.tech.india.moviestore.service.MovieService;

/*
 * @author Satinder kaur
 */

@RestController
@RequestMapping("/movie/v1")
public class MovieController {	
	private static final Logger log = LoggerFactory.getLogger(MovieController.class);
	
	@Autowired
	private MovieService service;
	
	
	@GetMapping("/movies")
	public ResponseEntity<List<MovieEntity>> getAllMovies(){
		log.debug("Request to get stored movie list");
		List<MovieEntity> list = service.getMovieList();
		return new ResponseEntity<List<MovieEntity>>(list, new HttpHeaders(), HttpStatus.OK);	
	}
	
	 @GetMapping("/movies/{id}")
	    public ResponseEntity<MovieEntity> getMovieById(@PathVariable(value = "id") Long movieId) throws RecordNotFoundException {
		 log.debug("Request to get stored movie by id:"+movieId); 
		 MovieEntity entity = service.getMovieById(movieId);
		 return new ResponseEntity<MovieEntity>(entity, new HttpHeaders(), HttpStatus.OK);		
	    }
	 
	 @PostMapping("/movies")
	    public ResponseEntity<MovieEntity> createMovie(@RequestBody MovieEntity movie){
		 log.debug("Create new movie");
		 MovieEntity created = service.createNewMovie(movie);
		 return new ResponseEntity<MovieEntity>(created, new HttpHeaders(), HttpStatus.OK);	    
	    }
	 
	 @PutMapping("/movies/{id}")
	    public MovieEntity updateMovie(@PathVariable(value = "id") Long movieId,@RequestBody MovieEntity movieDetails) throws RecordNotFoundException{
		 log.debug("Update movie by Id:"+movieId);
		 return service.updateMovieById(movieId);
	 }

	   @DeleteMapping("/movies/{id}")
	   public HttpStatus deleteMovie(@PathVariable(value = "id") Long movieId) throws RecordNotFoundException{
		   log.debug("Delete movie by id:"+movieId);
		   service.deleteMovieById(movieId);	
		   return HttpStatus.FORBIDDEN;
	   }

}
