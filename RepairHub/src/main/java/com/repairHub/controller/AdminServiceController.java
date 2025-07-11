package com.repairHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repairHub.entity.ServiceDetail;
import com.repairHub.service.ServiceDetailService;

@RestController

@RequestMapping("/admin/service")
public class AdminServiceController {
	
	@Autowired
	ServiceDetailService serviceService;
	
	@PostMapping("/add")
	public String addService(@RequestBody ServiceDetail service) {
		System.out.println("controller......");
		serviceService.addService(service);
		return "Service Added Successfull";
	}
	
	@GetMapping("/all")
	public List<ServiceDetail> getAllService(){
		return serviceService.getActiveServices();
	}
	
	@GetMapping("/inactiveservices")
	public List<ServiceDetail> getInactiveServices(){
		return serviceService.getInactiveServices();
	}
	
	@PutMapping("/deactivate/{id}")
	public String deactivateService(@PathVariable Long id) {
		serviceService.deactivateService(id);
		return "Service deactivate successfully";
	}
	
	@PutMapping("/update")
	public String updateService(@RequestBody ServiceDetail service) {
		serviceService.updateService(service);
		return "Service updated successfully";
	}
	
	@PutMapping("/activate/{id}")
	public ResponseEntity<String> activateService(@PathVariable Long id){
		ServiceDetail service = serviceService.getServiceById(id);
		service.setActive(true);
		serviceService.addService(service);
		
		return ResponseEntity.ok("Service Activated Successfully");
	}
	
}













