package com.repairHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.repairHub.entity.Admin;
import com.repairHub.repository.AdminRepository;

@Service
public class AdminUserDetailsService implements UserDetailsService{
	@Autowired
	private AdminRepository adminRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Admin admin = adminRepo.findByUsername(username);

		if(admin == null) {
			throw new UsernameNotFoundException("Admin not found");
		}
		
		return User.builder()
				.username(admin.getUsername())
				.password(admin.getPassword())
				.roles("ADMIN").build();
		
	}

}
