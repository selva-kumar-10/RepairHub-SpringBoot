package com.repairHub.controller;

import java.security.Principal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.repairHub.entity.Booking;
import com.repairHub.entity.Customer;
import com.repairHub.service.BookingService;
import com.repairHub.service.CustomerService;

@RestController
@RequestMapping("/customer/bookings")
public class CustomerBookHistoryController {

	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/my-bookings")
	public List<Booking> getBookingsByCustomer(Principal principal){
		Customer customer = customerService.findyByUsername(principal.getName());
		return bookingService.getBookingsByCustomer(customer);	
	}
}
