package com.repairHub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.repairHub.entity.ServiceDetail;
import com.repairHub.service.ServiceDetailService;

@RestController
@RequestMapping("/customer/service")
public class CustomerServiceViewController {

	@Autowired
	private ServiceDetailService serviceDetailService;
	
	@GetMapping("/all")
	public List<ServiceDetail> getAvailabeleServices(){
		return serviceDetailService.getActiveServices();
	}
}
