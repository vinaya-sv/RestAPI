package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Theatre;
import com.example.demo.repository.ApiRepositoryTheatre;

@Service
public class TheatreService {
	@Autowired
	ApiRepositoryTheatre theatreRepo;
	public String addTheatre(Theatre theatre) {
		if(theatreRepo.existsById(theatre.getTheatreId())) {
			return "Theatre already exists by same Id";
		}
		else {
			theatreRepo.save(theatre);
			return "Theatre added";
		}
	}
	
	public List<Theatre> getAllTheatre() {
		return theatreRepo.findAll();
	}
	
	public Optional<Theatre> getTheatreById(int id){
		return theatreRepo.findById(id);
	}

	public String updateTheatre(Theatre theatre) {
		if(theatreRepo.existsById(theatre.getTheatreId())) {
			theatreRepo.save(theatre);
			return "Theatre updated";
		}
		else {
			return "Theatre does not exits";
		}
	}

	public String deleteTheatreById(int id) {
		if(theatreRepo.existsById(id)) {
			theatreRepo.deleteById(id);
			return "Theatre Deleted";
		}
		else {
			return "Theatre does not exists";
		}
	}

	public List<Theatre> sortTheatreDetails(String field) {
		return theatreRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<Theatre> paginationTheatreDetails(int offset, int pageSize) {
		Page<Theatre> page=theatreRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<Theatre> paginationAndSortingTheatreDetails(int offset, int pageSize, String field) {
		Page<Theatre> page=theatreRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
		}
	
}
