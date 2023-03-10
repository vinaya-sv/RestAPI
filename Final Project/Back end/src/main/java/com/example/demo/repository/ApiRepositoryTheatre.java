package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Theatre;

@Repository
public interface ApiRepositoryTheatre extends JpaRepository<Theatre, Integer>{

}
