package com.repairHub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repairHub.entity.Admin;
import com.repairHub.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository adminRepo;
	public void registerAdmin(Admin admin) {
		adminRepo.save(admin);
	}

}
