package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ApiController{
	@GetMapping("/")
	public String Message() {
		return "Welcome Spring Boot!";
	}
}

