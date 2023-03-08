package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Movie;
import com.example.demo.repository.ApiRepositoryMovie;

@Service
public class MovieService {
	@Autowired
	ApiRepositoryMovie movieRepo;
	
	public String addMovie(Movie movie) {
		if(movieRepo.existsById(movie.getMovieId())) {
			return "Movie already exists by the same ID";
		}
		else {
			movieRepo.save(movie);
			return "Movie added";
		}
	}

	public List<Movie> getAllMovie() {
		return movieRepo.findAll();
	}

	public Optional<Movie> getMovieById(int id) {
		return movieRepo.findById(id);
	}

	public String updateMovie(Movie movie) {
		if(movieRepo.existsById(movie.getMovieId())) {
			movieRepo.save(movie);
			return "Movie updated";
		}
		else
		{
			return "Movie does not exists";
			
		}
	}

	public String deleteMovieById(int id) {
		if(movieRepo.existsById(id)) {
			movieRepo.deleteById(id);
			return "Movie Deleted";
		}
		else {
			return "Movie does not exists";
		}
	}

	public List<Movie> sortMovieDetails(String field) {
		return movieRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<Movie> paginationMovieDetails(int offset, int pageSize) {
		Page<Movie> page=movieRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<Movie> paginationAndSortingMovieDetails(int offset, int pageSize, String field) {
		Page<Movie> page=movieRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}
	
}
