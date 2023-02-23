package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Student;
import com.example.demo.repository.RepositoryClass;

@Service
public class ServiceClass {
	@Autowired
	RepositoryClass repository;
	
	public boolean addStudent(Student student) {
		repository.save(student);
		return true;
	}

	public List<Student> getStudent() {
		return repository.findAll();
	}

	public Optional<Student> getStudentById(int id) {
		return repository.findById(id);
	}
	
	public boolean putStudent(Student student) {
		repository.save(student);
		return true;
	}
	
	public boolean deleteStudentById(int id) {
		if(repository.existsById(id)) {
		repository.deleteById(id);
			return true;
		}
		else
			return false;
	}
	
	
	
	
}
