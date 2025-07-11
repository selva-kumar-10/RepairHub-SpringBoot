package com.repairHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repairHub.entity.Booking;
import com.repairHub.entity.Customer;
import com.repairHub.repository.BookingRepository;

@Service
public class BookingService {
	
	@Autowired
	private BookingRepository bookingRepo;
	
	public Booking bookService(Booking booking) {
		return bookingRepo.save(booking);
	}
	
	public List<Booking> getBookingsByCustomer(Customer customer){
		return bookingRepo.findByCustomer(customer);
	}
	
	public List<Booking> getAllBookings(){
		return bookingRepo.findAll();
	}

	public Booking getBookingById(Long id) {
		return bookingRepo.findById(id).orElse(null);
	}
}
