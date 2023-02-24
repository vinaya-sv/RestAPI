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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Child;
import com.example.demo.service.ServiceClass;

@RestController
public class ControllerClass {
	@Autowired
	ServiceClass service;
	
	@PostMapping("/")
	public boolean newChild(@RequestBody Child child) {
		return service.addChild(child);
	}

	//sorting
	@GetMapping("/{field}")
	public List<Child> readChildBySorting(@PathVariable String field){
		return service.getChildBySorting(field);
	}
	
	//pagination
	@GetMapping("/{offset}/{pageSize}")
	public List<Child> readChildByPagination(@PathVariable int offset, @PathVariable int pageSize){
		return service.getChildByPagination(offset,pageSize);
	}
	
	//sorting and pagination
	@GetMapping("/{offset}/{pageSize}/{field}")
	public List<Child> readChildByPaginationAndSorting(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		return service.getChildByPaginationAndSorting(offset,pageSize,field);
	}
	
	
}
