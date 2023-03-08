package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@RestController
public class BookingController {
	@Autowired
	BookingService service;
	
	@PostMapping("/book")
	public String bookTicket(@RequestBody Booking booking) {
		return service.bookTicket(booking);
	}
	@GetMapping("/book")
	public List<Booking> bookingDetails(){
		return service.bookingDetails();
	}
	@GetMapping("/book/{id}")
	public Optional<Booking> bookingDetailsById(@PathVariable int id){
		return service.bookingDetailsById(id);
	}
	
	@GetMapping("/book/sort/{field}")
	public List<Booking> sortedBookingDetails(@PathVariable String field){
		return service.sortedBookingDetails(field);
	}
	
	@GetMapping("/book/{offset}/{pageSize}")
	public List<Booking> paginationBookingDetails(@PathVariable int offset, @PathVariable int pageSize){
		return service.paginationBookingDetails(offset, pageSize);
	}
	
	@GetMapping("/book/{offset}/{pageSize}/{field}")
	public List<Booking> sortedAndPaginationBookingDetails(@PathVariable int offset, @PathVariable int pageSize, @PathVariable String field){
		return service.sortedAndPaginationBookingDetails(offset, pageSize, field);
	}
//	@GetMapping("/book/user/{id}")
//	public Optional<Booking> bookingDetailsByUserId(@PathVariable int id){
//		return service.bookingDetailsByUserId(id);
//	}
//	
//	@GetMapping("/book/movie/{id}")
//	public Optional<Booking> bookingDetailsByMovieId(@PathVariable int id){
//		return service.bookingDetailsByMovieId(id);
//	}
//	
//	@GetMapping("/book/theatre/{id}")
//	public Optional<Booking> bookingDetailsByTheatreId(@PathVariable int id){
//		return service.bookingDetailsByTheatreId(id);
//	}
	
	@DeleteMapping("/book/{id}")
	public String cancelBooking(@PathVariable int id) {
		return service.cancelBooking(id);
	}
	
}
