package com.repairHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.repairHub.entity.Customer;
import com.repairHub.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private CustomerService customerService;
	
	@PostMapping("/register")
	public String registerCustomer(@ModelAttribute Customer customer) {
		
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customerService.saveCustomerInDb(customer);
		return "redirect:/customer-login.html";
	}
	
	@GetMapping("/dashboard")
	public String customerDashboard() {
		return "/customer-dashboard.html";
	}
	
	@GetMapping("/service")
	public String customerViewService() {
		return "/customer-service.html";
	}
	@GetMapping("/bookings")
	public String customerHistory() {
		return "/customer-history.html";
	}
}
