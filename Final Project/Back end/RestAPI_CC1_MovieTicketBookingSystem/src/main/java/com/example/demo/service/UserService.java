package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.User;
import com.example.demo.repository.ApiRepositoryUser;

@Service
public class UserService {
	@Autowired
	ApiRepositoryUser userRepo;
	
	public String addUser(User user) {
		if(userRepo.existsById(user.getUserId())) {
			return "User already exists with the same ID";
		}
		else {
			userRepo.save(user);
			return "User Added";
		}
	}

	public List<User> getAllUser() {
		return userRepo.findAll();
	}

	public String updateUser(User user) {
		if(userRepo.existsById(user.getUserId())) {
			userRepo.save(user);
			return "User updated";
		}
		else
			return "User does not exits";
	}

	public String deleteUser(int id) {
		if(userRepo.existsById(id)) {
			userRepo.deleteById(id);
			return "User deleted";
		}
		else {
			return "User does not exists";
		}
	}

	public User getUserById(int id) {
		if(userRepo.existsById(id))
		return (userRepo.findById(id)).get();
		return null;
	}

	public List<User> signInVerfication(String emailId, String password) {
		List<User> emptyList=new ArrayList<>();
		List<User> list=userRepo.findUserByEmailId(emailId);
		if(list.size()==0) {
			return list;
		}
		if(password.equals(list.get(0).getPassword())) {
			return list;
		}
		return emptyList;
		
	}
	
	
	
}
