package com.repairHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repairHub.entity.Booking;
import com.repairHub.service.BookingService;

@RestController
@RequestMapping("/admin/bookings")
public class AdminViewBookingController {

	@Autowired
	private BookingService bookingService;
	
	@GetMapping("/all")
	public List<Booking> getAllBookings(){
		return bookingService.getAllBookings();
	}
	
	
	@PutMapping("/accept/{id}")
	public String accpectBooking (@PathVariable Long id) {
		Booking booking = bookingService.getBookingById(id);
		booking.setStatus("Accpected");
		bookingService.bookService(booking);
		 return "Booking accpected successfully";
	
}
	
}