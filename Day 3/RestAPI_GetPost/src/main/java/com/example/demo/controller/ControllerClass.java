package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	
	@Autowired
	ServiceClass service;
	
	@PostMapping("/")
	public boolean CreateEmployee(@RequestBody Employee employee) {
		return service.addEmployee(employee);
		
	}
	@GetMapping("/")
	public List<Employee> read(){
		return service.getEmployee();
	}
	
	@GetMapping("/{id}")
	public Optional<Employee> readById(@PathVariable int id){
		return service.getEmployeeById(id);
	}
	
	
	
	
}
