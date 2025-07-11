package com.repairHub.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.repairHub.entity.ServiceDetail;

@Repository
public interface ServiceDetailRepository extends JpaRepository<ServiceDetail,Long>{

	@Query("Select s from ServiceDetail s where s.active = false")
	List<ServiceDetail> findInactiveServices();
	
	List<ServiceDetail> findByActiveTrue();
	
	ServiceDetail getServiceById(Long serviceId);
}

