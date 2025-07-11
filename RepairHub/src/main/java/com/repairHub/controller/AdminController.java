package com.repairHub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.repairHub.entity.Admin;
import com.repairHub.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/register")
	public String registerAdmin(@ModelAttribute Admin admin) {
		admin.setPassword(passwordEncoder.encode(admin.getPassword()));
		adminService.registerAdmin(admin);
		return "admin-login.html";
	}
	
	@GetMapping("/dashboard")
	public String adminDashboard() {
		return "/admin-dashboard.html";
	}
	@GetMapping("/service/add")
	public String adminServiceAdd() {
		return "/admin-add-service.html";
	}
	
	@GetMapping("/bookings")
	public String adminViewBookings() {
		return "/admin-viewbookings.html";
	}
	
	@GetMapping("/edit")
	public String changeServices() {
		return "/admin-editservice.html";
	}
	
	@GetMapping("/register")
	public String adminRegister() {
		return "/admin-register.html";
	}
	
	@GetMapping("/login")
	public String adminLogin() {
		return "/admin-login.html";
	}
	
	@GetMapping("/inactive")
	public String inactiveServices() {
		return "/admin-deactivate-services.html";
		}
}
