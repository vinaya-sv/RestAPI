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
import com.example.demo.model.Theatre;
import com.example.demo.service.TheatreService;

@RestController
public class TheatreController {
	@Autowired
	TheatreService service;
	
	@PostMapping("/theatre")
	public String addTheatre(@RequestBody Theatre theatre) {
		return service.addTheatre(theatre);
	}
	
	@GetMapping("/theatre")
	public List<Theatre> getAllTheatre(){
		return service.getAllTheatre();
	}
	
	@GetMapping("/theatre/{id}")
	public Optional<Theatre> getTheatreById(@PathVariable int id){
		return service.getTheatreById(id);
	}
	
	@GetMapping("/theatre/sort/{field}")
	public List<Theatre> sortTheatreDetails(@PathVariable String field){
		return service.sortTheatreDetails(field);
	}
	
	@GetMapping("/theatre/{offset}/{pageSize}")
	public List<Theatre> paginationTheatreDetails(@PathVariable int offset, @PathVariable int pageSize){
		return service.paginationTheatreDetails(offset,pageSize);
	}
	
	@GetMapping("/theatre/{offset}/{pageSize}/{field}")
	public List<Theatre> paginationAndSortingTheatreDetails(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		return service.paginationAndSortingTheatreDetails(offset,pageSize,field);
	}
	@PutMapping("/theatre")
	public String updateTheatre(@RequestBody Theatre theatre) {
		return service.updateTheatre(theatre);
	}
	
	@DeleteMapping("/theatre/{id}")
	public String deleteTheatreById(@PathVariable int id) {
		return service.deleteTheatreById(id);
	}
	
	
}
