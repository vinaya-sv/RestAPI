package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Movie;
import com.example.demo.service.MovieService;

@RestController
public class MovieController {
	@Autowired
	MovieService service;

	@PostMapping("/movie")
	public String addMovie(@RequestBody Movie movie) {
		return service.addMovie(movie);
	}
	
	@GetMapping("/movie")
	public List<Movie> getAllMovie(){
		return service.getAllMovie();
	}
	
	@GetMapping("/movie/{id}")
	public Optional<Movie> getMovieById(@PathVariable int id){
		return service.getMovieById(id);
	}
	
	@PutMapping("/movie")
	public String updateMovie(@RequestBody Movie movie) {
		return service.updateMovie(movie);
	}
	
	@DeleteMapping("/movie/{id}")
	public String deleteMovieBydId(@PathVariable int id) {
		return service.deleteMovieById(id);
	}
	
	@GetMapping("/movie/sort/{field}")
	public List<Movie> sortMovieDetails(@PathVariable String field) {
		return service.sortMovieDetails(field);
	}
	
	@GetMapping("/movie/{offset}/{pageSize}")
	public List<Movie>  paginationMovieDetails(@PathVariable int offset, @PathVariable int pageSize) {
		return service.paginationMovieDetails(offset,pageSize);
	}
	
	@GetMapping("/movie/{offset}/{pageSize}/{field}")
	public List<Movie> paginationAndSortingMovieDetails(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field) {
		return service.paginationAndSortingMovieDetails(offset, pageSize, field);
	}
}






