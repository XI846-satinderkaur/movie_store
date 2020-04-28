package com.xebia.india.moviestore;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.xebia.india.moviestore.controller.MovieController;
import com.xebia.india.moviestore.entity.MovieEntity;
import com.xebia.india.moviestore.service.MovieService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = MovieController.class, secure = false)
public class MoviestoreApplicationTests {

	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MovieService movieService;
	
	@Test
    public void getMovieList() throws Exception{
		List<MovieEntity> movieResponseList = new ArrayList<MovieEntity>();
		
		Mockito.when(movieService.getMovieList()).thenReturn(movieResponseList);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movie/v1/movies").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "[{\"id\": 3,\"title\": \"India\",\"category\": \"bollywood\",\"ratings\": 5},{\"id\": 4,\"title\": \"Spanich\",\"category\": \"hollywood\",\"ratings\": 3},{\"id\": 5,\"title\": \"Independence\",\"category\": \"bollywood\",\"ratings\": 4}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), JSONCompareMode.LENIENT);        
    }

	
	@Test
	public void contextLoads() {
	}
	
		
	@Test
    public void getMovieById() throws Exception{
		Long id = 3L;
	    MovieEntity movieResponseEntity = new MovieEntity();
		Mockito.when(movieService.getMovieById(id)).thenReturn(movieResponseEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movie/v1/movies/3").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "[{\"id\": 3,\"title\": \"India\",\"category\": \"bollywood\",\"ratings\": 5}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), JSONCompareMode.LENIENT);        
    }
	 
	@Test
    public void createNewMovie() throws Exception{
		//Long id = 3L;
	    MovieEntity movieResponseEntity = new MovieEntity();
	    movieResponseEntity.setTitle("Avengers");
	    movieResponseEntity.setCategory("Hollywood");
	    movieResponseEntity.setRatings(3);
		Mockito.when(movieService.createNewMovie(movieResponseEntity)).thenReturn(movieResponseEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movie/v1/movies").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();		
		System.out.println(result.getResponse());
		       
    }
	 
	@Test
    public void updateMovieById() throws Exception{
		Long movieId = 3L;
	    MovieEntity movieResponseEntity = new MovieEntity();
	    movieResponseEntity.setTitle("Joker");
	    movieResponseEntity.setCategory("Hollywood");
	    movieResponseEntity.setRatings(2);
		Mockito.when(movieService.updateMovieById(movieId)).thenReturn(movieResponseEntity);
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movie/v1/movies/3").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "[{\"id\": 3,\"title\": \"India\",\"category\": \"bollywood\",\"ratings\": 5}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), JSONCompareMode.LENIENT);        
    }

	/*@Test
    public void deleteMovieById() throws Exception{
		Long movieId = 3L;
	   // MovieEntity movieResponseEntity = new MovieEntity();	    
	    Mockito.when(movieService.deleteMovieById(movieId)).then;
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/movie/v1/movies/3").accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		
		System.out.println(result.getResponse());
		String expected = "[{\"id\": 3,\"title\": \"India\",\"category\": \"bollywood\",\"ratings\": 5}]";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), JSONCompareMode.LENIENT);        
    }*/

}
