package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService service;
	
	@PostMapping("/user")
	@CrossOrigin(origins = "http://localhost:3000")

	public String addUser(@RequestBody User user) {
		return service.addUser(user);
	}
	
	@GetMapping("/user/signIn/{emailId}/{password}")
	@CrossOrigin(origins="http://localhost:3000")
	public List<User> signInVerfication(@PathVariable String emailId, @PathVariable String password){
		return service.signInVerfication(emailId, password);
	}
	
	@GetMapping("/user")
	@CrossOrigin(origins = "http://localhost:3000")
	public List<User> getAllUsers() {
		return service.getAllUser();
	}
	
	@GetMapping("/user/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public User getUserById(@PathVariable int id){
		return service.getUserById(id);
	}
	
	@PutMapping("/user")
	@CrossOrigin(origins = "http://localhost:3000")
	public String updateUser(@RequestBody User user) {
		return service.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	@CrossOrigin(origins = "http://localhost:3000")
	public String deleteUser(@PathVariable int id) {
		return service.deleteUser(id);
	}
}
