package com.example.demo.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import com.example.demo.model.Booking;
import com.example.demo.repository.ApiRepositoryBooking;

@Service
public class BookingService {
	@Autowired
	ApiRepositoryBooking bookRepo;

	public String bookTicket(Booking booking) {
		if(bookRepo.existsById(booking.getBookingId())) {
			return "Ticket already booked";
		}
		else {
		bookRepo.save(booking);
		return "Ticket Booked";
		}
	}

	public List<Booking> bookingDetails() {
		return bookRepo.findAll();
	}

	public Optional<Booking> bookingDetailsById(int id) {
		return bookRepo.findById(id);
	}

	public String cancelBooking(int id) {
		if(bookRepo.existsById(id)){
			bookRepo.deleteById(id);
			return "Ticket Cancelled";
		}
		else {
			return "Ticket does not exist";
		}
	}

	public List<Booking> sortedBookingDetails(String field) {
		return bookRepo.findAll(Sort.by(Sort.Direction.ASC,field));
	}

	public List<Booking> paginationBookingDetails(int offset, int pageSize){
		Page<Booking> page=bookRepo.findAll(PageRequest.of(offset, pageSize));
		return page.getContent();
	}

	public List<Booking> sortedAndPaginationBookingDetails(int offset, int pageSize, String field) {
		Page<Booking> page=bookRepo.findAll(PageRequest.of(offset, pageSize,Sort.by(field)));
		return page.getContent();
	}
	
	
	
}
