package com.repairHub.controller;

import java.security.Principal;
import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.repairHub.entity.Booking;
import com.repairHub.entity.Customer;
import com.repairHub.entity.ServiceDetail;
import com.repairHub.service.BookingService;
import com.repairHub.service.CustomerService;
import com.repairHub.service.ServiceDetailService;

@RestController
@RequestMapping("/customer/booking")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private ServiceDetailService serviceDetailService;
	
	@PostMapping("/add")
	public String bookService(@RequestParam Long serviceId, Principal principal) {
		
		Customer customer = customerService.findyByUsername(principal.getName());
		
		ServiceDetail serviceDetail = serviceDetailService.getServiceById(serviceId);
		
		Booking booking = new Booking();
		booking.setCustomer(customer);
		booking.setServiceDetail(serviceDetail);
		booking.setBookingDate(LocalDate.now());
		
		bookingService.bookService(booking);
		return "Server Booked successfully!";
	}
}

