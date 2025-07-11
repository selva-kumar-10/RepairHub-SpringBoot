package com.repairHub.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.repairHub.entity.ServiceDetail;
import com.repairHub.repository.ServiceDetailRepository;

@Service
public class ServiceDetailService {

	@Autowired
	private ServiceDetailRepository serviceRepo;
	
	public void addService(ServiceDetail service) {
		serviceRepo.save(service);
	}

	public List<ServiceDetail> getAllServices() {
		return serviceRepo.findAll();
	}

	public ServiceDetail getServiceById(Long serviceId) {
		return serviceRepo.findById(serviceId).orElse(null);
	}
	
	public void deactivateService(Long id) {
		ServiceDetail service = serviceRepo.findById(id).orElseThrow(()-> new
				 RuntimeException ("Service  not found"));
		service.setActive(false);
		serviceRepo.save(service);
	}
	
	public ServiceDetail updateService(ServiceDetail service) {
		return serviceRepo.save(service);
	}
	
	public List<ServiceDetail> getActiveServices(){
		return serviceRepo.findByActiveTrue();
	}
	
	public List<ServiceDetail> getInactiveServices(){
		return serviceRepo.findInactiveServices();
	}

	public void saveService(ServiceDetail service) {
		// TODO Auto-generated method stub
		
	}
}
