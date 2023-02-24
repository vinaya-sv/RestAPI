package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.demo.model.Child;
import com.example.demo.repository.RepositoryClass;

@Service
public class ServiceClass {
	@Autowired
	RepositoryClass repository;
	
	public boolean addChild(Child child) {
		repository.save(child);
		return true;
	}

	public List<Child> getChildBySorting(String field) {
		return repository.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<Child> getChildByPagination(int offset, int pageSize) {
		Page<Child> page=repository.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<Child> getChildByPaginationAndSorting(int offset, int pageSize, String field) {
		Page<Child> page=repository.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}
	
	
	
	
}
