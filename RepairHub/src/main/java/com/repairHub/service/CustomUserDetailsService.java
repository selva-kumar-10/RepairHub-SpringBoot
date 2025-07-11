package com.repairHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.repairHub.entity.Customer;
import com.repairHub.repository.CustomerRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService{
//	public CustomUserDetailsService() {
//		System.out.println("Working");
//	}

	@Autowired
	private CustomerRepository customerRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByusername(username);
		
		if(customer == null) {
//			System.out.println("hiiiii");
			throw new UsernameNotFoundException("User not found");
		}
		return User.builder()
				.username(customer.getUsername())
				.password(customer.getPassword())
				.roles("CUSTOMER").build();
	}
	
}
