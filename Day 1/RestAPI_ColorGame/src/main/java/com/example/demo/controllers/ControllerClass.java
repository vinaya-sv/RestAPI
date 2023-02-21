package com.example.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class ControllerClass {
	private String color="Green";
	
	@GetMapping("/")
	public String getColor() {
		return "My favourite color is "+color;
	}
}

