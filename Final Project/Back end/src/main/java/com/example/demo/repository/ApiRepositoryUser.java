package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;
@Repository
public interface ApiRepositoryUser extends JpaRepository<User, Integer>{
	public List<User> findUserByEmailId(String emailId);
}
