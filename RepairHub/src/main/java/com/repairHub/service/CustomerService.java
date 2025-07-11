package com.repairHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.repairHub.entity.Customer;
import com.repairHub.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer saveCustomerInDb(Customer customer) {
		return customerRepo.save(customer);
	}
	
	public Customer findyByUsername(String username) {
		return customerRepo.findByusername(username);
	}

	public List<Customer> getAllCustomers() {
		return customerRepo.findAll();
	}
}
