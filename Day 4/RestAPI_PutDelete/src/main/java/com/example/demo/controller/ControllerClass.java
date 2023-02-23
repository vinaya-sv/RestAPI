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

import com.example.demo.model.Student;
import com.example.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	@Autowired
	ServiceClass service;
	
	@PostMapping("/")
	public boolean newStudent(@RequestBody Student student) {
		return service.addStudent(student);
	}
	
	@GetMapping("/")
	public List<Student> readStudent(){
		return service.getStudent();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> readStudentById(@PathVariable int id){
		return service.getStudentById(id);
	}
	
	@PutMapping("/")
	public boolean UpdateStudent(@RequestBody Student student) {
		return service.putStudent(student);
	}
	
	@DeleteMapping("/{id}")
	public boolean DeleteStudent(@PathVariable int id) {
		return service.deleteStudentById(id);
	}
}
