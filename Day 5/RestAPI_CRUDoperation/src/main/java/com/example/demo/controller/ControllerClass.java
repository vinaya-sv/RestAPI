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

import com.example.demo.model.Book;
import com.example.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	@Autowired
	ServiceClass service;
	
	@PostMapping("/")
	public boolean newBook(@RequestBody Book book) {
		return service.addBook(book);
	}
	
	@GetMapping("/")
	public List<Book> readBook(){
		return service.getBook();
	}
	
	@GetMapping("/{id}")
	public Optional<Book> readBookById(@PathVariable int id){
		return service.getBookById(id);
	}
	
	@PutMapping("/")
	public boolean UpdateBook(@RequestBody Book book) {
		return service.putBook(book);
	}
	
	@DeleteMapping("/{id}")
	public boolean DeleteBook(@PathVariable int id) {
		return service.deleteBookById(id);
	}
}
