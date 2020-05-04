package com.tech.india.moviestore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import com.tech.india.moviestore.MoviestoreApplication;
import com.tech.india.moviestore.entity.MovieEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MoviestoreApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MoviestoreApplicationTests {
     @Autowired
     private TestRestTemplate restTemplate;

     @LocalServerPort
     private int port;

     private String getRootUrl() {
         return "http://localhost:" + port+"/movie/v1";
     }

     @Test
     public void contextLoads() {

     }

     @Test
     public void testGetAllMovies() {
     HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<String>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(getRootUrl() + "/movies",
        HttpMethod.GET, entity, String.class);  
        assertNotNull(response.getBody());
    }

    @Test
    public void testGetMovieById() {
    	MovieEntity movie = restTemplate.getForObject(getRootUrl() + "/movies/1", MovieEntity.class);
        System.out.println(movie.getTitle());
        assertNotNull(movie);
    }

    @Test
    public void testCreateMovie() {
    	MovieEntity movie = new MovieEntity();
    	movie.setTitle("HKM");
    	movie.setCategory("Bollywood");
    	movie.setRatings(4.3F);        
        ResponseEntity<MovieEntity> postResponse = restTemplate.postForEntity(getRootUrl() + "/movies", movie, MovieEntity.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
    }

    @Test
    public void testUpdateMovie() {
        int id = 1;
        MovieEntity movie = restTemplate.getForObject(getRootUrl() + "/movies/" + id, MovieEntity.class);
        movie.setTitle("HKM");
    	movie.setCategory("Bollywood");
    	movie.setRatings(4.3F);        
        restTemplate.put(getRootUrl() + "/employees/" + id, movie);
        MovieEntity updatedEmployee = restTemplate.getForObject(getRootUrl() + "/movies/" + id, MovieEntity.class);
        assertNotNull(updatedEmployee);
    }

    @Test
    public void testDeleteMovie() {
         int id = 2;
         MovieEntity movie = restTemplate.getForObject(getRootUrl() + "/movies/" + id, MovieEntity.class);
         assertNotNull(movie);
         restTemplate.delete(getRootUrl() + "/movies/" + id);
         try {
              movie = restTemplate.getForObject(getRootUrl() + "/movies/" + id, MovieEntity.class);
         } catch (final HttpClientErrorException e) {
              assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
         }
    }
}