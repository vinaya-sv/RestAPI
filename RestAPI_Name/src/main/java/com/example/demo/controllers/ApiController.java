package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ApiController {
	private String getName="IAmNeo";
	
	@GetMapping("/")
	public String Message() {
		return "Welcome "+getName+"!";
	}
}

