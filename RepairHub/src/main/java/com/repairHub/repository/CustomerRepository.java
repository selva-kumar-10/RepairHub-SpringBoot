package com.repairHub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.repairHub.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Long> {

	Customer findByusername(String username);
	
}
